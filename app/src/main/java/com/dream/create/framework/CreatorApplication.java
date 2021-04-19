package com.dream.create.framework;

import android.app.Application;
import android.content.Context;

import com.dream.create.BuildConfig;
import com.facebook.flipper.android.AndroidFlipperClient;
import com.facebook.flipper.android.utils.FlipperUtils;
import com.facebook.flipper.core.FlipperClient;
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin;
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin;
import com.facebook.flipper.plugins.inspector.DescriptorMapping;
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin;
import com.facebook.flipper.plugins.leakcanary2.FlipperLeakListener;
import com.facebook.flipper.plugins.leakcanary2.LeakCanary2FlipperPlugin;
import com.facebook.soloader.SoLoader;

import leakcanary.LeakCanary;

public class CreatorApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            final FlipperClient client = AndroidFlipperClient.getInstance(this);
            client.addPlugin(new InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));
            client.start();
        }
        SoLoader.init(this, false);
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            final FlipperClient client = AndroidFlipperClient.getInstance(this);
            //layoutInspector
            client.addPlugin(new InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()));
            //dataBase
            client.addPlugin(new DatabasesFlipperPlugin(this));
            //leakCanary
            LeakCanary.Config config = LeakCanary.getConfig();
            config.copy(
                    config.getDumpHeap(),
                    config.getDumpHeapWhenDebugging(),
                    config.getRetainedVisibleThreshold(),
                    config.getReferenceMatchers(),
                    config.getObjectInspectors(),
                    /*config.getOnHeapAnalyzedListener()*/new FlipperLeakListener(),
                    config.getMetadataExtractor(),
                    config.getComputeRetainedHeapSize(),
                    config.getMaxStoredHeapDumps(),
                    config.getRequestWriteExternalStoragePermission(),
                    config.getLeakingObjectFinder(),
                    config.getUseExperimentalLeakFinders()
            );
            LeakCanary.setConfig(config);
            client.addPlugin(new LeakCanary2FlipperPlugin());
            //crash
            client.addPlugin(CrashReporterPlugin.getInstance());
            client.start();
        }
    }
}
