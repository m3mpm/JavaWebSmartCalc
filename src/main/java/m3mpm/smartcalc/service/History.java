package m3mpm.smartcalc.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

@Service
public class History {
    private static Preferences historyPrefs = null;

    public History() {
        historyPrefs = Preferences.userRoot().node("history");
    }

    public void saveRecordToHistory(String str){
        historyPrefs.put(new Date().toString(),str);
    }

    public String[] getHistory() throws BackingStoreException {
        String[] keys = historyPrefs.keys();
        String[] history = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            history[i] = historyPrefs.get(keys[i], null);
        }
        return history;
    }

    public void cleanHistory() throws BackingStoreException {
        historyPrefs.clear();
    }

}
