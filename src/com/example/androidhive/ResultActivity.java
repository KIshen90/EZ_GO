package com.example.androidhive;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
 
@SuppressLint("NewApi")
public class ResultActivity extends ListActivity {
 
    // Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    //JSONParser jParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> ticketList;
 
    // url to get all ticket list
   // private static String url_all_ticket = "http://"+MainScreenActivity.localIPAddress+"/getTicket.php";
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_ticket = "ticket";
    private static final String TAG_TID = "tid";
    private static final String TAG_FROM = "locationFrom";
    private static final String TAG_TO = "locationTo";
    private static final String TAG_SDATE = "sdate";
    private static final String TAG_EDATE = "edate";
    private static final String TAG_PRICE = "price";
    private static final String TAG_TRANSTYPE = "transtype";
    
 
    // ticket JSONArray
    JSONArray ticket = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
 
        // Hashmap for ListView
       ticketList = new ArrayList<HashMap<String, String>>() ;
 
        // Loading ticket in Background Thread
        new LoadAllticket().execute();
        
        // Get listview
        ListView lv = getListView();
 
        // on seleting single product
        // launching Edit Product Screen
        lv.setOnItemClickListener(new OnItemClickListener() {
        
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
                String tid = ((TextView) view.findViewById(R.id.tid)).getText().toString();
                String from = ((TextView) view.findViewById(R.id.from)).getText().toString();
                String to = ((TextView) view.findViewById(R.id.to)).getText().toString();
                String sdate = ((TextView) view.findViewById(R.id.sdate)).getText().toString();
                String edate = ((TextView) view.findViewById(R.id.edate)).getText().toString();
                String price = ((TextView) view.findViewById(R.id.price)).getText().toString();
                String transtype = ((TextView) view.findViewById(R.id.transtype)).getText().toString();
                
                // Starting new intent
                //Intent in = new Intent(getApplicationContext(),
                        //EditProductActivity.class);
                // sending pid to next activity
                //in.putExtra(TAG_TID, pid);
 
                // starting new activity and expecting some response back
                //startActivityForResult(in, 100);
            }
        });
 
    }
 
    // Response from Edit Product Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if result code 100
        if (resultCode == 100) {
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
 
    }
 
    /**
     * Background Async Task to Load all product by making HTTP Request
     * */
    @SuppressLint("NewApi")
	class LoadAllticket extends AsyncTask<String, String, String> {
 
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ResultActivity.this);
            pDialog.setMessage("Loading ticket. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
 
        /**
         * getting All ticket from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
           // List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
           // JSONObject json = jParser.makeHttpRequest(url_all_ticket, "GET", params);
 
            // Check your log cat for JSON response
           // Log.d("All ticket: ", json.toString());
        	
        	Intent intent = getIntent();
    	    String jsonArray = intent.getStringExtra("jArray");
    	    
            try {
            	
        	    ticket = new JSONArray(jsonArray);
    	        System.out.println(ticket.toString(2));
                // Checking for SUCCESS TAG
                //int success = json.getInt(TAG_SUCCESS);
 
               
                    // ticket found
                    // Getting Array of ticket
                    //ticket = json.getJSONArray(TAG_ticket);
 
    	        
    	    		Log.e("Before For loop check","AAAA");
                    // looping through All ticket
                    for (int i = 0; i < ticket.length(); i++) {
                    	Log.e("ticket length = ",""+ticket.length());
                    	Log.e("For loop check i = ",""+i);
                        JSONObject c = ticket.getJSONObject(i);                   
                        Log.e("After getJSONObject i = ",""+i);
                        // Storing each json item in variable
                        String id = c.getString(TAG_TID);
                        String from = c.getString(TAG_FROM);
                        String to = c.getString(TAG_TO);
                       String sdate = c.getString(TAG_SDATE);
                        String edate = c.getString(TAG_EDATE);
                        String price = c.getString(TAG_PRICE);
                        String transtype = c.getString(TAG_TRANSTYPE);
 
                        Log.e("from ",from);
                        // creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
 
                        // adding each child node to HashMap key => value
                        map.put(TAG_TID, id);
                        map.put(TAG_FROM, "From:\t\t\t\t\t\t\t" + from);
                        map.put(TAG_TO, "To:\t\t\t\t\t\t\t\t" + to);
                        map.put(TAG_SDATE, "Start Date:\t\t\t\t\t" + sdate);
                        map.put(TAG_EDATE, "End Date:\t\t\t\t\t\t" + edate);
                        map.put(TAG_PRICE, "Price:\t\t\t\t\t\t\t$" + price);
                        map.put(TAG_TRANSTYPE, "Transportation Type:\t" + transtype);
 
                        // adding HashList to ArrayList
                        ticketList.add(map);
                    }
            
    	    		
    	    		/*ashMap<String, String> pairs = new HashMap<String, String>();
    	    		for (int i = 0; i < ticket.length(); i++) {
    	    		   JSONObject j = ticket.optJSONObject(i);
    	    		   Iterator<String> it = j.keys();
    	    		   while (it.hasNext()) {
    	    		      String n = it.next();
    	    		      pairs.put(n, j.toString());
    	    		   }
    	    		
    	    		}*/
            } catch (JSONException e) {
                e.printStackTrace();
            }
 
            return null;
        }
 
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all ticket
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter = new SimpleAdapter(
                            ResultActivity.this, ticketList,
                            R.layout.list_item, new String[] { TAG_TID,
                                    TAG_FROM, TAG_TO, TAG_SDATE, TAG_EDATE, TAG_PRICE, TAG_TRANSTYPE},
                            new int[] { R.id.tid, R.id.from, R.id.to, R.id.sdate, R.id.edate, R.id.price, R.id.transtype });
                    // updating listview
                    setListAdapter(adapter);
                }
            });
 
        }
 
    }
}