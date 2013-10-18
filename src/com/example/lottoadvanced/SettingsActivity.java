package com.example.lottoadvanced;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends Activity {
	EditText etMin, etMax, etAmount;
	Button btMin, btMax, btAmount;
	TextView tvMin, tvMax, tvAmount;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		etMin = (EditText)findViewById(R.id.editText1);
		etMax = (EditText)findViewById(R.id.editText2);
		etAmount = (EditText)findViewById(R.id.editText3);
		btMin = (Button)findViewById(R.id.btMin);
		btMax = (Button)findViewById(R.id.btMax);
		btAmount = (Button)findViewById(R.id.btAmount);
		tvMin = (TextView)findViewById(R.id.textView1);
		tvMax = (TextView)findViewById(R.id.textView2);
		tvAmount = (TextView)findViewById(R.id.textView3);
		final LottoLogic lotto = LottoLogic.getLottoLogic();
		loadPrefs();
		
		class ButtonsListener implements View.OnClickListener
		{
			public void onClick(View v)
			{
				if (v == btMin)
				{
					int min = Integer.parseInt(etMin.getText().toString());
					savePrefs("MINIMUM", min);
					lotto.setMinNumber(min);
				}
				else if (v == btMax)
				{
					int max = Integer.parseInt(etMax.getText().toString());
					savePrefs("MAXIMUM", max);
					lotto.setMaxNumber(max);
				}
				else if (v == btAmount)
				{
					int amount = Integer.parseInt(etAmount.getText().toString());
					savePrefs("AMOUNT", amount);
					lotto.setNumberOfGuessedNumbers(amount);
				}
				
			}
		}
		
		View.OnClickListener listener = new ButtonsListener();
		btMin.setOnClickListener(listener);
		btMax.setOnClickListener(listener);
		btAmount.setOnClickListener(listener);
	}
	
	private void loadPrefs() 
	{
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		int minValue = sp.getInt("MINIMUM", 1);
		int maxValue = sp.getInt("MAXIMUM", 36);
		int amountValue = sp.getInt("AMOUNT", 6);
		etMin.setText("" + minValue);
		etMax.setText("" + maxValue);
		etAmount.setText("" + amountValue);
		
	}


	private void savePrefs(String key, int value) 
	{
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	


}
