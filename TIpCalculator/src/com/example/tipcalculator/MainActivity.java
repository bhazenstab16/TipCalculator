package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	double dblBillAmount;
	double dblOtherTip;
	
	String strBillAmount;
	String strOtherTip;
	
	EditText etBillAmount;
	EditText etOtherTipAmount;
	TextView tvTipTotal;
	
	DecimalFormat currency = new DecimalFormat("$###,###.00");
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       etBillAmount = (EditText)findViewById(R.id.editTextBillAmount);
       etOtherTipAmount = (EditText)findViewById(R.id.editTextOtherTipAmount);
       tvTipTotal = (TextView)findViewById(R.id.textViewTipTotal);
        
       etOtherTipAmount.setEnabled(false);
       
       etOtherTipAmount.addTextChangedListener( new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			strOtherTip = etOtherTipAmount.getText().toString();
			dblOtherTip = Double.parseDouble(strOtherTip);
			tvTipTotal.setText("The tip amount is " + currency.format (dblBillAmount * dblOtherTip/100.0));
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	}
       );
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    protected void onRestart()
    {
    	super.onRestart();
    	//...
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

    public void onRadioGroup1Click(View v)
    {
    	strBillAmount = etBillAmount.getText().toString();
    	
    	if( !TextUtils.isEmpty(strBillAmount) )
    	{
    		dblBillAmount = Double.parseDouble(strBillAmount);
    	
    		switch( v.getId() )
    		{
    			case R.id.radio10:
    				etOtherTipAmount.setEnabled(false);
    				tvTipTotal.setText("The tip amount is " + currency.format (dblBillAmount*.1));
    				break;
    			case R.id.radio15:
    				etOtherTipAmount.setEnabled(false);
    				tvTipTotal.setText("The tip amount is " + currency.format (dblBillAmount*.15));
    				break;
    			case R.id.radio20:
    				etOtherTipAmount.setEnabled(false);
    				tvTipTotal.setText("The tip amount is " + currency.format (dblBillAmount*.2));
    				break;
    			case R.id.radioOther:
   					etOtherTipAmount.setEnabled(true);
    				
    				break;
    	}
    	}
    }
    
}
