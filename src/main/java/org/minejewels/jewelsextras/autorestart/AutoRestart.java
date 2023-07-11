package org.minejewels.jewelsextras.autorestart;

import lombok.Data;

@Data
public class AutoRestart {
    private long startTimeInSeconds;
    private long targetTimeInSeconds;

    public AutoRestart(long targetTimeInSeconds) {
        this.startTimeInSeconds = System.currentTimeMillis() / 1000;
        this.targetTimeInSeconds = targetTimeInSeconds;
    }

    public long getTimeRemainingInSeconds() {
        long currentTimeInSeconds = System.currentTimeMillis() / 1000;
        long elapsedTimeInSeconds = currentTimeInSeconds - startTimeInSeconds;
        long timeRemainingInSeconds = targetTimeInSeconds - elapsedTimeInSeconds;

        return Math.max(0, timeRemainingInSeconds);
    }
}
