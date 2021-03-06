package org.jdc.template.util;

import android.util.Log;

import org.apache.commons.io.FileUtils;
import org.jdc.template.App;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Response;


@Singleton
public class WebServiceUtil {
    private static final String TAG = App.createTag(WebServiceUtil.class);

    @Inject
    public WebServiceUtil() {
        // Dagger
    }

    public boolean saveResponseToFile(Response<ResponseBody> response, File outputFile) {
        Log.d(TAG, "Saving response [" + response.raw().request().url().url().toString() + "] to file [" + outputFile.getAbsolutePath() + "]...");
        boolean success = false;
        try {
            FileUtils.copyInputStreamToFile(response.body().byteStream(), outputFile); // Closes all streams
            success = outputFile.exists();
        } catch (IOException e) {
            Log.e(TAG, "Failed to save webservice stream to [" + outputFile.getName() + "] error: " + e.getMessage(), e);

            if (outputFile.exists()) {
                //noinspection ResultOfMethodCallIgnored
                outputFile.delete(); // NOSONAR - just delete if we can but we don't need to check the return value
            }
        }
        return success;
    }
}
