package com.example.currentplacedetailsonmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class ProfileActivity extends Activity implements PopupMenu.OnMenuItemClickListener
{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void showPopup(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.profile_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.option_get_place:
                startActivity(new Intent( this, MapsActivityCurrentPlace.class));
                return true;
            case R.id.nav_leaderboard:
                startActivity(new Intent(this, LeaderboardActivity.class));
                return true;
            case R.id.nav_share:
                startActivity(new Intent(this, ShareActivity.class));
                return true;
            default: return false;
        }
    }
}
