package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.xiaomi.smarthome.R;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

class RedBoxDialog extends Dialog implements AdapterView.OnItemClickListener {
    public boolean isReporting = false;
    public final DevSupportManager mDevSupportManager;
    private Button mDismissButton;
    private final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    public View mLineSeparator;
    public ProgressBar mLoadingIndicator;
    public final RedBoxHandler mRedBoxHandler;
    private Button mReloadJsButton;
    public Button mReportButton;
    private View.OnClickListener mReportButtonOnClickListener = new View.OnClickListener() {
        /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass2 */

        public void onClick(View view) {
            if (RedBoxDialog.this.mRedBoxHandler != null && RedBoxDialog.this.mRedBoxHandler.isReportEnabled() && !RedBoxDialog.this.isReporting) {
                RedBoxDialog redBoxDialog = RedBoxDialog.this;
                redBoxDialog.isReporting = true;
                ((TextView) Assertions.assertNotNull(redBoxDialog.mReportTextView)).setText("Reporting...");
                ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setVisibility(0);
                ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(0);
                ((View) Assertions.assertNotNull(RedBoxDialog.this.mLineSeparator)).setVisibility(0);
                ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(false);
                String sourceUrl = RedBoxDialog.this.mDevSupportManager.getSourceUrl();
                RedBoxDialog.this.mRedBoxHandler.reportRedbox(view.getContext(), (String) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorTitle()), (StackFrame[]) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorStack()), sourceUrl, (RedBoxHandler.ReportCompletedListener) Assertions.assertNotNull(RedBoxDialog.this.mReportCompletedListener));
            }
        }
    };
    public RedBoxHandler.ReportCompletedListener mReportCompletedListener = new RedBoxHandler.ReportCompletedListener() {
        /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass1 */

        public void onReportSuccess(SpannedString spannedString) {
            RedBoxDialog redBoxDialog = RedBoxDialog.this;
            redBoxDialog.isReporting = false;
            ((Button) Assertions.assertNotNull(redBoxDialog.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }

        public void onReportError(SpannedString spannedString) {
            RedBoxDialog redBoxDialog = RedBoxDialog.this;
            redBoxDialog.isReporting = false;
            ((Button) Assertions.assertNotNull(redBoxDialog.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }
    };
    public TextView mReportTextView;
    private ListView mStackView;

    static class StackAdapter extends BaseAdapter {
        private final StackFrame[] mStack;
        private final String mTitle;

        public boolean areAllItemsEnabled() {
            return false;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public boolean isEnabled(int i) {
            return i > 0;
        }

        static class FrameViewHolder {
            public final TextView mFileView;
            public final TextView mMethodView;

            private FrameViewHolder(View view) {
                this.mMethodView = (TextView) view.findViewById(R.id.rn_frame_method);
                this.mFileView = (TextView) view.findViewById(R.id.rn_frame_file);
            }
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.mTitle = str;
            this.mStack = stackFrameArr;
        }

        public int getCount() {
            return this.mStack.length + 1;
        }

        public Object getItem(int i) {
            return i == 0 ? this.mTitle : this.mStack[i - 1];
        }

        /* JADX WARN: Type inference failed for: r3v8, types: [android.view.View] */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        /* JADX WARNING: Multi-variable type inference failed */
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (i == 0) {
                if (view != null) {
                    textView = (TextView) view;
                } else {
                    textView = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.redbox_item_title, viewGroup, false);
                }
                textView.setText(this.mTitle.replaceAll("\\x1b\\[[0-9;]*m", ""));
                return textView;
            }
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.redbox_item_frame, viewGroup, false);
                view.setTag(new FrameViewHolder(view));
            }
            StackFrame stackFrame = this.mStack[i - 1];
            FrameViewHolder frameViewHolder = (FrameViewHolder) view.getTag();
            frameViewHolder.mMethodView.setText(stackFrame.getMethod());
            frameViewHolder.mFileView.setText(StackTraceHelper.formatFrameSource(stackFrame));
            return view;
        }
    }

    static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> {
        private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        private final DevSupportManager mDevSupportManager;

        private OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(StackFrame... stackFrameArr) {
            try {
                String uri = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (StackFrame stackFrameToJson : stackFrameArr) {
                    okHttpClient.newCall(new Request.Builder().url(uri).post(RequestBody.create(JSON, stackFrameToJson(stackFrameToJson).toString())).build()).execute();
                }
            } catch (Exception e) {
                FLog.e("ReactNative", "Could not open stack frame", e);
            }
            return null;
        }

        private static JSONObject stackFrameToJson(StackFrame stackFrame) {
            return new JSONObject((Map<?, ?>) MapBuilder.of("file", stackFrame.getFile(), "methodName", stackFrame.getMethod(), "lineNumber", Integer.valueOf(stackFrame.getLine()), "column", Integer.valueOf(stackFrame.getColumn())));
        }
    }

    protected RedBoxDialog(Context context, DevSupportManager devSupportManager, RedBoxHandler redBoxHandler) {
        super(context, 2132738842);
        requestWindowFeature(1);
        setContentView((int) R.layout.redbox_view);
        this.mDevSupportManager = devSupportManager;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mRedBoxHandler = redBoxHandler;
        this.mStackView = (ListView) findViewById(R.id.rn_redbox_stack);
        this.mStackView.setOnItemClickListener(this);
        this.mReloadJsButton = (Button) findViewById(R.id.rn_redbox_reload_button);
        this.mReloadJsButton.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass3 */

            public void onClick(View view) {
                RedBoxDialog.this.mDevSupportManager.handleReloadJS();
            }
        });
        this.mDismissButton = (Button) findViewById(R.id.rn_redbox_dismiss_button);
        this.mDismissButton.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.react.devsupport.RedBoxDialog.AnonymousClass4 */

            public void onClick(View view) {
                RedBoxDialog.this.dismiss();
            }
        });
        RedBoxHandler redBoxHandler2 = this.mRedBoxHandler;
        if (redBoxHandler2 != null && redBoxHandler2.isReportEnabled()) {
            this.mLoadingIndicator = (ProgressBar) findViewById(R.id.rn_redbox_loading_indicator);
            this.mLineSeparator = findViewById(R.id.rn_redbox_line_separator);
            this.mReportTextView = (TextView) findViewById(R.id.rn_redbox_report_label);
            this.mReportTextView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mReportTextView.setHighlightColor(0);
            this.mReportButton = (Button) findViewById(R.id.rn_redbox_report_button);
            this.mReportButton.setOnClickListener(this.mReportButtonOnClickListener);
        }
    }

    public void setExceptionDetails(String str, StackFrame[] stackFrameArr) {
        this.mStackView.setAdapter((ListAdapter) new StackAdapter(str, stackFrameArr));
    }

    public void resetReporting() {
        RedBoxHandler redBoxHandler = this.mRedBoxHandler;
        if (redBoxHandler != null && redBoxHandler.isReportEnabled()) {
            this.isReporting = false;
            ((TextView) Assertions.assertNotNull(this.mReportTextView)).setVisibility(8);
            ((ProgressBar) Assertions.assertNotNull(this.mLoadingIndicator)).setVisibility(8);
            ((View) Assertions.assertNotNull(this.mLineSeparator)).setVisibility(8);
            ((Button) Assertions.assertNotNull(this.mReportButton)).setVisibility(0);
            ((Button) Assertions.assertNotNull(this.mReportButton)).setEnabled(true);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new OpenStackFrameTask(this.mDevSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (StackFrame) this.mStackView.getAdapter().getItem(i));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.mDevSupportManager.showDevOptionsDialog();
            return true;
        }
        if (this.mDoubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
            this.mDevSupportManager.handleReloadJS();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
