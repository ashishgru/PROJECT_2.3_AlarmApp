

package ashishrpa.acagild.alarmclock.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;


import java.util.UUID;

import ashishrpa.acagild.alarmclock.model.Alarm;

/**
 * This class implements a SQLite CursorWrapper for the alarm object data.
 */
public class AlarmCursorWrapper extends CursorWrapper {
    public AlarmCursorWrapper(Cursor cursor) { super(cursor); }

    public Alarm getAlarm() {
        String uuidString = getString(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.UUID));
        String title = getString(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.TITLE));
        boolean isEnabled = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.ENABLED)) != 0);
        int timeHour = getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.HOUR));
        int timeMinute = getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.MINUTE));
        String alarmToneString = getString(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.TONE));
        Uri alarmTone = null;
        if (!alarmToneString.isEmpty()) {
            alarmTone = Uri.parse(alarmToneString);
        }
        String[] repeatingDays = getString(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.DAYS)).split(",");
        boolean vibrate = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.VIBRATE)) != 0);
        boolean tongueTwister = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.TONGUE_TWISTER)) != 0);
        boolean colorCapture = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.COLOR_CAPTURE)) != 0);
        boolean expressYourself = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.EXPRESS_YOURSELF)) != 0);
        boolean isNew = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.NEW)) != 0);
        boolean isSnoozed = (getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.SNOOZED)) != 0);
        int snoozedHour = getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.SNOOZED_HOUR));
        int snoozedMinute = getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.SNOOZED_MINUTE));
        int snoozedSeconds = getInt(getColumnIndex(AlarmDbSchema.AlarmTable.Columns.SNOOZED_SECONDS));

        Alarm alarm = new Alarm(UUID.fromString(uuidString));
        alarm.setTitle(title);
        alarm.setIsEnabled(isEnabled);
        alarm.setTimeHour(timeHour);
        alarm.setTimeMinute(timeMinute);
        alarm.setAlarmTone(alarmTone);
        for (int i = 0; i < repeatingDays.length; i++) {
            alarm.setRepeatingDay(i, !repeatingDays[i].equals("false"));
        }
        alarm.setVibrate(vibrate);
        alarm.setTongueTwisterEnabled(tongueTwister);
        alarm.setColorCaptureEnabled(colorCapture);
        alarm.setExpressYourselfEnabled(expressYourself);
        alarm.setNew(isNew);
        alarm.setSnoozed(isSnoozed);
        alarm.setSnoozeHour(snoozedHour);
        alarm.setSnoozeMinute(snoozedMinute);
        alarm.setSnoozeSeconds(snoozedSeconds);

        return alarm;
    }
}
