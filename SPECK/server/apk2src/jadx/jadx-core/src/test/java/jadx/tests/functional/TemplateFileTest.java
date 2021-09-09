package jadx.tests.functional;

import org.junit.jupiter.api.Test;

import jadx.core.export.TemplateFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TemplateFileTest {

	@Test
	public void testBuildGradle() throws Exception {
		TemplateFile tmpl = TemplateFile.fromResources("/export/build.gradle.tmpl");
		tmpl.add("applicationId", "SOME_ID");
		tmpl.add("minSdkVersion", 1);
		tmpl.add("targetSdkVersion", 2);
		String res = tmpl.build();
		System.out.println(res);

		assertThat(res, containsString("applicationId 'SOME_ID'"));
		assertThat(res, containsString("targetSdkVersion 2"));
	}
}
