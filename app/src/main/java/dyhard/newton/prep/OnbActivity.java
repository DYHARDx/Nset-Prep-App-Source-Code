package dyhard.newton.prep;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.shimmer.*;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class OnbActivity extends AppCompatActivity {
	
	private String User_Name = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview4;
	private TextView textview3;
	private TextView textview5;
	
	private Intent i = new Intent();
	private SharedPreferences onb;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.onb);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		textview5 = findViewById(R.id.textview5);
		onb = getSharedPreferences("ftime", Activity.MODE_PRIVATE);
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog d = new AlertDialog.Builder(OnbActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.name,null); 
				d.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				d.setView(inflate);
				final View linear1 = (View) inflate.findViewById(R.id.linear1);
				final TextView heading = (TextView) inflate.findViewById(R.id.heading);
				final TextView subh = (TextView) inflate.findViewById(R.id.subh);
				final TextView start = (TextView) inflate.findViewById(R.id.start);
				LinearLayout edtext_bg = (LinearLayout) inflate.findViewById(R.id.edtext_bg);
				
				final EditText edtext= new EditText(OnbActivity.this);
				
				LinearLayout.LayoutParams liet = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				edtext.setLayoutParams(liet);
				edtext_bg.addView(edtext);
				edtext.setHint("eg. Aman Singh");
				edtext.setSingleLine(true);
				edtext.setTextSize((float)18);
				edtext.setTextColor(Color.parseColor("#ffffff"));
				edtext.setHintTextColor(0xFFEEEEEE);
				edtext.setBackgroundColor(Color.TRANSPARENT);
				d.setCancelable(true);
				heading.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
				subh.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
				edtext.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 0);
				start.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
				if (false) {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(0xFF000000);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)1,0xFFFFFFFF);
					if (Build.VERSION.SDK_INT >= 21){
						linear1.setElevation((int)5);}
					
					android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
					
					android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
					linear1.setClickable(true);
					linear1.setBackground(ripdrb);
					
				} else {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(0xFF000000);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)1,0xFFFFFFFF);
					linear1.setBackground(gd);
					if (Build.VERSION.SDK_INT >= 21){
						linear1.setElevation((int)5);}
					
				}
				if (false) {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(Color.TRANSPARENT);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)2,0xFFFFFFFF);
					if (Build.VERSION.SDK_INT >= 21){
						edtext_bg.setElevation((int)4);}
					
					android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
					
					android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
					edtext_bg.setClickable(true);
					edtext_bg.setBackground(ripdrb);
					
				} else {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(Color.TRANSPARENT);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)2,0xFFFFFFFF);
					edtext_bg.setBackground(gd);
					if (Build.VERSION.SDK_INT >= 21){
						edtext_bg.setElevation((int)4);}
					
				}
				if (true) {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(0xFFFFFFFF);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)0,0xFFFFFFFF);
					if (Build.VERSION.SDK_INT >= 21){
						start.setElevation((int)1);}
					
					android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
					
					android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
					start.setClickable(true);
					start.setBackground(ripdrb);
					
				} else {
					
					android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
					gd.setColor(0xFFFFFFFF);
					gd.setCornerRadius((int)25);
					gd.setStroke((int)0,0xFFFFFFFF);
					start.setBackground(gd);
					if (Build.VERSION.SDK_INT >= 21){
						start.setElevation((int)1);}
					
				}
				start.setOnClickListener(new View.OnClickListener(){
						@Override
						public void onClick(View _view){
						User_Name = edtext.getText().toString();
						if (edtext.getText().toString().equals("")) {
							d.dismiss();
							SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Your Name");
						} else {
							onb.edit().putString("name", "true").commit();
							d.dismiss();
							i.setClass(getApplicationContext(), MainActivity.class);
							i.putExtra("username", edtext.getText().toString());
							onb.edit().putString("username", edtext.getText().toString()).commit();
							startActivity(i);
							finish();
						}		 
						}
				});
				d.show();
			}
		});
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w = this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#33000000"));
		}
		_removeScollBar(vscroll1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
		textview5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)1, 0xFF000000, 0xFFFFFFFF));
		if (onb.contains("name")) {
			if (onb.getString("name", "").equals("true")) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			} else {
				
			}
		}
	}
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}