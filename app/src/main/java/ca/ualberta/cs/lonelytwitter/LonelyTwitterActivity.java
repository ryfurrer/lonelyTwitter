package ca.ualberta.cs.lonelytwitter;

/**
 *  Finally, added a way for each tweet to have a list of moods.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private CheckBox sadBox;
	private CheckBox happyBox;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayList<Mood> moods = new ArrayList<Mood>();
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		happyBox = (CheckBox) findViewById(R.id.chkHappy);//
		sadBox = (CheckBox) findViewById(R.id.chkDepresseed);//

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				clearFile();
				finish();

			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Date date = new Date(System.currentTimeMillis());

				if (happyBox.isChecked())//
					moods.add(new Happy(date));//
				if (sadBox.isChecked())//
					moods.add(new Depressed(date));//

				setResult(RESULT_OK);
				ImportantTweet tweet = new ImportantTweet();
				try{

					tweet.setMessage(bodyText.getText().toString());
					tweet.setMoods(moods);
					tweets.add(tweet);
					adapter.notifyDataSetChanged();
					saveInFile();
				} catch (TweetTooLongException e) {
					e.printStackTrace();
				}

				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));//
			Gson gson = new Gson();
			Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
			tweets = gson.fromJson(reader, listTweetType);


		} catch (FileNotFoundException e) {
			//tweets = new ArrayList<String>();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter writer = new BufferedWriter(osw);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			writer.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void clearFile() {
		tweets = new ArrayList<Tweet>();
		adapter.notifyDataSetChanged();
		saveInFile();
	}
}