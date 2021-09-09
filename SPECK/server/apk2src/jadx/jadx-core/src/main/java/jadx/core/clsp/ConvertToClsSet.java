package jadx.core.clsp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.api.JadxArgs;
import jadx.core.dex.nodes.RootNode;
import jadx.core.utils.exceptions.DecodeException;
import jadx.core.utils.files.InputFile;

/**
 * Utility class for convert dex or jar to jadx classes set (.jcst)
 */
public class ConvertToClsSet {
	private static final Logger LOG = LoggerFactory.getLogger(ConvertToClsSet.class);

	public static void usage() {
		LOG.info("<output .jcst or .jar file> <several input dex or jar files> ");
	}

	public static void main(String[] args) throws IOException, DecodeException {
		if (args.length < 2) {
			usage();
			System.exit(1);
		}
		Path output = Paths.get(args[0]);

		List<InputFile> inputFiles = new ArrayList<>(args.length - 1);
		for (int i = 1; i < args.length; i++) {
			File f = new File(args[i]);
			if (f.isDirectory()) {
				addFilesFromDirectory(f, inputFiles);
			} else {
				InputFile.addFilesFrom(f, inputFiles, false);
			}
		}
		for (InputFile inputFile : inputFiles) {
			LOG.info("Loaded: {}", inputFile.getFile());
		}

		JadxArgs jadxArgs = new JadxArgs();
		jadxArgs.setRenameFlags(EnumSet.noneOf(JadxArgs.RenameEnum.class));
		RootNode root = new RootNode(jadxArgs);
		root.load(inputFiles);

		ClsSet set = new ClsSet(root);
		set.loadFrom(root);
		set.save(output);
		LOG.info("Output: {}, file size: {}B", output, output.toFile().length());
		LOG.info("done");
	}

	private static void addFilesFromDirectory(File dir, List<InputFile> inputFiles) {
		File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				addFilesFromDirectory(file, inputFiles);
			} else {
				try {
					InputFile.addFilesFrom(file, inputFiles, false);
				} catch (Exception e) {
					LOG.warn("Skip file: {}, load error: {}", file, e.getMessage());
				}
			}
		}
	}
}
