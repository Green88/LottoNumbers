package com.example.lottoadvanced;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.widget.TextView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String text = "...";
		TextView tv = new TextView(this);
		text = getString("about.txt");
		tv.setText(text);
		setContentView(tv);
	}

	public String getString(String fileName)
	{
		String text = "nothing";
		AssetManager am = getAssets();
		InputStream is = null;
		try
		{
			is = am.open(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int tav = is.read();
			while(tav!=-1)
			{
				baos.write(tav);
				tav = is.read();
			}
			text = baos.toString();
		}
		catch(IOException e)
		{
			text = e.getMessage();			
		}
		finally
		{
			if(is!=null)
			{
				try
				{
					is.close();
				}
				catch(IOException e)
				{
					text = e.getMessage();
				}
			}
		}
		return text;
	}
}
