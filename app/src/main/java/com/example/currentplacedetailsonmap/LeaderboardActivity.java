package com.example.currentplacedetailsonmap;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeaderboardActivity extends Activity {
    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        listView = findViewById(R.id.listView);
        downloadJSON("view_leaderboard.php");
    }

    private void downloadJSON(final String webURL) {
        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(webURL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = br.readLine()) != null) {
                        // Add to JSON string
                        sb.append(json + "\n");
                    }
                    // Return JSON string
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        DownloadJSON dlJSON = new DownloadJSON();
        dlJSON.execute();
    }

    //loadIntoListView
}
