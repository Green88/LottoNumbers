package com.example.lottoadvanced;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final LottoLogic lotto = LottoLogic.getLottoLogic();
		final Button btSet = (Button) findViewById(R.id.settings_bt);
		final Button btHelp = (Button) findViewById(R.id.help_bt);
		final Button btAbout = (Button) findViewById(R.id.about_bt);
		
		final Button btGen = (Button) findViewById(R.id.generate_bt);
		btGen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				int[] numbers = null;
				String toastNums = null;
				StringBuilder sb = new StringBuilder();
				numbers = lotto.generateNumbers();
				for(int i = 0; i<lotto.getNumberOfGuessedNumbers(); i++)
				{
					sb.append(numbers[i]);
					sb.append("  ");
				}
				toastNums = sb.toString();
				Toast toast = Toast.makeText(MainActivity.this,toastNums,Toast.LENGTH_LONG);
				toast.setDuration(5000);
				toast.show();
			}
		});
		
		
		
		class ButtonsListener implements View.OnClickListener
		{
			Intent intent = null;
			public void onClick(View v)
			{
				if (v == btSet)
				{
					intent = new Intent(MainActivity.this, SettingsActivity.class);
				}
				else if (v == btHelp)
				{
					intent = new Intent(MainActivity.this, HelpActivity.class);
				}
				else if (v == btAbout)
				{
					intent = new Intent(MainActivity.this, AboutActivity.class);
				}
				startActivity(intent);
			}
		}
		
		View.OnClickListener listener = new ButtonsListener();
		btSet.setOnClickListener(listener);
		btHelp.setOnClickListener(listener);
		btAbout.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main_menu, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.menuAbout:
			startActivity(new Intent(MainActivity.this, AboutActivity.class));
			return true;
		case R.id.menuHelp:
			startActivity(new Intent(MainActivity.this, HelpActivity.class));
			return true;
		case R.id.menuSettings:
			startActivity(new Intent(MainActivity.this, SettingsActivity.class));
			return true;
		}
		return false;
	}

}
