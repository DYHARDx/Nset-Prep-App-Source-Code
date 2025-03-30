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
import android.widget.EditText;
import android.widget.ImageView;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import android.provider.Settings;
import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	DatabaseReference database;
	
	private ScrollView scroll;
	private LinearLayout linear_main;
	private TextView tx_title;
	private TextView tx_subtitle;
	private ImageView imageview1;
	private LinearLayout l_email;
	private LinearLayout l_pass;
	private LinearLayout btnLogin;
	private LinearLayout div;
	private LinearLayout button_mode;
	private LinearLayout div2;
	private LinearLayout lin_more;
	private ImageView im_email;
	private TextView name;
	private ImageView im_pass;
	private EditText etKey;
	private ImageView im_forget_pass;
	private TextView tvStatus;
	private LinearLayout devider1;
	private TextView tx_inf;
	private LinearLayout devider2;
	private TextView tx_mode;
	private LinearLayout div3;
	private TextView tx_inf2;
	private LinearLayout div4;
	private LinearLayout l_google;
	private LinearLayout linear3;
	private LinearLayout l_fb;
	private LinearLayout linear4;
	private LinearLayout l_twitter;
	private LinearLayout linear5;
	private LinearLayout l_insta;
	private ImageView im_google;
	private ImageView im_fb;
	private ImageView im_twitter;
	private ImageView im_insta;
	
	private Intent i = new Intent();
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
	private SharedPreferences onb;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		scroll = findViewById(R.id.scroll);
		linear_main = findViewById(R.id.linear_main);
		tx_title = findViewById(R.id.tx_title);
		tx_subtitle = findViewById(R.id.tx_subtitle);
		imageview1 = findViewById(R.id.imageview1);
		l_email = findViewById(R.id.l_email);
		l_pass = findViewById(R.id.l_pass);
		btnLogin = findViewById(R.id.btnLogin);
		div = findViewById(R.id.div);
		button_mode = findViewById(R.id.button_mode);
		div2 = findViewById(R.id.div2);
		lin_more = findViewById(R.id.lin_more);
		im_email = findViewById(R.id.im_email);
		name = findViewById(R.id.name);
		im_pass = findViewById(R.id.im_pass);
		etKey = findViewById(R.id.etKey);
		im_forget_pass = findViewById(R.id.im_forget_pass);
		tvStatus = findViewById(R.id.tvStatus);
		devider1 = findViewById(R.id.devider1);
		tx_inf = findViewById(R.id.tx_inf);
		devider2 = findViewById(R.id.devider2);
		tx_mode = findViewById(R.id.tx_mode);
		div3 = findViewById(R.id.div3);
		tx_inf2 = findViewById(R.id.tx_inf2);
		div4 = findViewById(R.id.div4);
		l_google = findViewById(R.id.l_google);
		linear3 = findViewById(R.id.linear3);
		l_fb = findViewById(R.id.l_fb);
		linear4 = findViewById(R.id.linear4);
		l_twitter = findViewById(R.id.l_twitter);
		linear5 = findViewById(R.id.linear5);
		l_insta = findViewById(R.id.l_insta);
		im_google = findViewById(R.id.im_google);
		im_fb = findViewById(R.id.im_fb);
		im_twitter = findViewById(R.id.im_twitter);
		im_insta = findViewById(R.id.im_insta);
		onb = getSharedPreferences("ftime", Activity.MODE_PRIVATE);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				onb.edit().putString("pass", etKey.getText().toString()).commit();
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
	}
	
	private void initializeLogic() {
		_UI();
		database = FirebaseDatabase.getInstance().getReference("keys");
		
		        btnLogin.setOnClickListener(new View.OnClickListener() {
			            @Override
			            public void onClick(View v) {
				                attemptLogin();
				            }
			        });
		    }
	
	    private void attemptLogin() {
		        final String key = etKey.getText().toString().trim();
		        final String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
		
		        if (key.isEmpty()) {
			            tvStatus.setText("Status: Key cannot be empty");
			            return;
			        }
		
		        database.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
			            @Override
			            public void onDataChange(DataSnapshot snapshot) {
				                if (snapshot.exists()) {
					                    String storedDeviceId = snapshot.child("device_id").getValue(String.class);
					                    Boolean used = snapshot.child("used").getValue(Boolean.class);
					                    String expirationDate = snapshot.child("expiration_date").getValue(String.class);
					
					                    if (storedDeviceId.equals("null") && !used) {
						                        Map<String, Object> updates = new HashMap<>();
						                        updates.put("device_id", deviceId);
						                        updates.put("used", true);
						 database.child(key).updateChildren(updates);
						                        tvStatus.setText("Status: Login successful");
						
						i.setClass(getApplicationContext(), MainActivity.class);
						startActivity(i);
					} else if (storedDeviceId.equals(deviceId)) {
						                        checkExpiration(expirationDate);
						                    } else {
						                        tvStatus.setText("Status: Key already used on another device");
						                    }
					                } else {
					                    tvStatus.setText("Status: Invalid key");
					                }
				            }
			
			            @Override
			            public void onCancelled(DatabaseError error) {
				                tvStatus.setText("Status: Error occurred: " + error.getMessage());
				            }
			        });
		    }
	
	    private void checkExpiration(String expirationDate) {
		    try {
			        // Parse the expiration date from the string
			        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			        Date expDate = sdf.parse(expirationDate);
			
			        // Get the current date
			        Date currentDate = new Date();
			
			        // Check if the current date is after the expiration date
			        if (currentDate.after(expDate)) {
				            tvStatus.setText("Status: Key has expired");
				        } else {
				            tvStatus.setText("Status: Expiration check passed, login successful");
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
			    } catch (ParseException e) {
			        tvStatus.setText("Status: Error parsing expiration date");
		}
	}
	
	public void _UI() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); }
		getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));
		getWindow().setNavigationBarColor(Color.parseColor("#FFFFFF"));
		scroll.setVerticalScrollBarEnabled(false);
		_Shadow(0, 100, "#EEEEEE", l_email);
		_Shadow(0, 100, "#EEEEEE", l_pass);
		name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		etKey.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		tvStatus.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		tx_inf.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		tx_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bloggersansbold.ttf"), 0);
		tx_subtitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		tx_mode.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		tx_inf2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/notosans.ttf"), 0);
		im_email.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
		im_pass.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
		im_forget_pass.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
		_rippleRoundStroke(btnLogin, "#00BCD4", "#0097A7", 100, 0, "#00BCD4");
		_rippleRoundStroke(button_mode, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		_rippleRoundStroke(im_forget_pass, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		_rippleRoundStroke(l_google, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		_rippleRoundStroke(l_fb, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		_rippleRoundStroke(l_twitter, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		_rippleRoundStroke(l_insta, "#EEEEEE", "#BDBDBD", 100, 0, "#EEEEEE");
		tx_title.setText("Welcome back");
		tx_subtitle.setText("Let's login with your account details to continue");
		im_forget_pass.setVisibility(View.VISIBLE);
		name.setText(onb.getString("username", ""));
		etKey.setText(onb.getString("pass", ""));
	}
	
	
	public void _Shadow(final double _sadw, final double _cru, final String _wc, final View _widgets) {
		android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
		wd.setColor(Color.parseColor(_wc));
		wd.setCornerRadius((int)_cru);
		_widgets.setElevation((int)_sadw);
		_widgets.setBackground(wd);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
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