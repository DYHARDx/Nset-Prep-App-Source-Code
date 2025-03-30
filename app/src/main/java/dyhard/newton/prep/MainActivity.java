package dyhard.newton.prep;

import dyhard.newton.prep.OnbActivity;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import com.facebook.shimmer.*;
import com.google.android.material.button.*;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import androidx.core.widget.NestedScrollView;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String selected = "";
	private String charSeq = "";
	private String filter = "";
	private double sim = 0;
	private double length = 0;
	private double d = 0;
	private String searching = "";
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private NestedScrollView vscroll1;
	private LinearLayout main_bg;
	private LinearLayout mbg;
	private LinearLayout linear9;
	private LinearLayout linear2;
	private CardView cardview1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview4;
	private TextView textview3;
	private LinearLayout linear5;
	private ImageView imageview2;
	private LinearLayout linear6;
	private ImageView imageview1;
	private LinearLayout linear7;
	private LinearLayout linear11;
	private ImageView imageview4;
	private TextView textview5;
	private TextView textview0;
	private HorizontalScrollView hscroll1;
	private SwipeRefreshLayout swiperefreshlayout1;
	private LinearLayout linear8;
	private TextView textview6;
	private TextView math;
	private TextView gt;
	private TextView English;
	private LinearLayout linear10;
	private LinearLayout loding_linear;
	private LinearLayout content1_linear;
	private LinearLayout network_linear;
	private ProgressBar progressbar1;
	private ListView interview;
	private ListView maths;
	private ListView gtA;
	private ListView eng;
	private ImageView imageview3;
	private TextView textview1;
	private MaterialButton retry_button;
	
	private Intent i = new Intent();
	private TimerTask t;
	private SharedPreferences data;
	private TimerTask tr;
	private TimerTask tsim;
	private RequestNetwork newtw;
	private RequestNetwork.RequestListener _newtw_request_listener;
	private Calendar cel = Calendar.getInstance();
	private Intent telegram = new Intent();
	private DatabaseReference Interview = _firebase.getReference("Interview");
	private ChildEventListener _Interview_child_listener;
	private DatabaseReference mathematics = _firebase.getReference("mathematics");
	private ChildEventListener _mathematics_child_listener;
	private DatabaseReference GT = _firebase.getReference("GT");
	private ChildEventListener _GT_child_listener;
	private DatabaseReference Eng = _firebase.getReference("Eng");
	private ChildEventListener _Eng_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		main_bg = findViewById(R.id.main_bg);
		mbg = findViewById(R.id.mbg);
		linear9 = findViewById(R.id.linear9);
		linear2 = findViewById(R.id.linear2);
		cardview1 = findViewById(R.id.cardview1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		linear6 = findViewById(R.id.linear6);
		imageview1 = findViewById(R.id.imageview1);
		linear7 = findViewById(R.id.linear7);
		linear11 = findViewById(R.id.linear11);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		textview0 = findViewById(R.id.textview0);
		hscroll1 = findViewById(R.id.hscroll1);
		swiperefreshlayout1 = findViewById(R.id.swiperefreshlayout1);
		linear8 = findViewById(R.id.linear8);
		textview6 = findViewById(R.id.textview6);
		math = findViewById(R.id.math);
		gt = findViewById(R.id.gt);
		English = findViewById(R.id.English);
		linear10 = findViewById(R.id.linear10);
		loding_linear = findViewById(R.id.loding_linear);
		content1_linear = findViewById(R.id.content1_linear);
		network_linear = findViewById(R.id.network_linear);
		progressbar1 = findViewById(R.id.progressbar1);
		interview = findViewById(R.id.interview);
		maths = findViewById(R.id.maths);
		gtA = findViewById(R.id.gtA);
		eng = findViewById(R.id.eng);
		imageview3 = findViewById(R.id.imageview3);
		textview1 = findViewById(R.id.textview1);
		retry_button = findViewById(R.id.retry_button);
		data = getSharedPreferences("ftime", Activity.MODE_PRIVATE);
		newtw = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NoticeActivity.class);
				startActivity(i);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				loding_linear.setVisibility(View.GONE);
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					sim = 0;
					
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					
				}
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					interview.setVisibility(View.VISIBLE);
					maths.setVisibility(View.GONE);
					gtA.setVisibility(View.GONE);
					eng.setVisibility(View.GONE);
					textview6.setTextColor(0xFFFFFFFF);
					textview6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF263238));
					math.setTextColor(0xFF546E7A);
					math.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					gt.setTextColor(0xFF546E7A);
					gt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					English.setTextColor(0xFF546E7A);
					English.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					Interview.addChildEventListener(_Interview_child_listener);
					mathematics.removeEventListener(_mathematics_child_listener);
					GT.removeEventListener(_GT_child_listener);
					Eng.removeEventListener(_Eng_child_listener);
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					Interview.removeEventListener(_Interview_child_listener);
				}
			}
		});
		
		math.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					interview.setVisibility(View.GONE);
					maths.setVisibility(View.VISIBLE);
					gtA.setVisibility(View.GONE);
					eng.setVisibility(View.GONE);
					textview6.setTextColor(0xFF546E7A);
					textview6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					math.setTextColor(0xFFFFFFFF);
					math.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF263238));
					gt.setTextColor(0xFF546E7A);
					gt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					English.setTextColor(0xFF546E7A);
					English.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					mathematics.addChildEventListener(_mathematics_child_listener);
					Interview.removeEventListener(_Interview_child_listener);
					GT.removeEventListener(_GT_child_listener);
					Eng.removeEventListener(_Eng_child_listener);
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					mathematics.removeEventListener(_mathematics_child_listener);
				}
			}
		});
		
		gt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					interview.setVisibility(View.GONE);
					maths.setVisibility(View.GONE);
					gtA.setVisibility(View.VISIBLE);
					eng.setVisibility(View.GONE);
					textview6.setTextColor(0xFF546E7A);
					textview6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					math.setTextColor(0xFF546E7A);
					math.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					gt.setTextColor(0xFFFFFFFF);
					gt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF263238));
					English.setTextColor(0xFF546E7A);
					English.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					GT.addChildEventListener(_GT_child_listener);
					Interview.removeEventListener(_Interview_child_listener);
					mathematics.removeEventListener(_mathematics_child_listener);
					Eng.removeEventListener(_Eng_child_listener);
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					GT.removeEventListener(_GT_child_listener);
				}
			}
		});
		
		English.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				cel = Calendar.getInstance();
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					interview.setVisibility(View.GONE);
					maths.setVisibility(View.GONE);
					gtA.setVisibility(View.GONE);
					eng.setVisibility(View.VISIBLE);
					textview6.setTextColor(0xFF546E7A);
					textview6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					math.setTextColor(0xFF546E7A);
					math.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					gt.setTextColor(0xFF546E7A);
					gt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
					English.setTextColor(0xFFFFFFFF);
					English.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF263238));
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					interview.setAdapter(new InterviewAdapter(list));
					((BaseAdapter)interview.getAdapter()).notifyDataSetChanged();
					Interview.removeEventListener(_Interview_child_listener);
					Eng.addChildEventListener(_Eng_child_listener);
					mathematics.removeEventListener(_mathematics_child_listener);
					GT.removeEventListener(_GT_child_listener);
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					Eng.removeEventListener(_Eng_child_listener);
				}
			}
		});
		
		retry_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				loding_linear.setVisibility(View.GONE);
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
					
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
					
				}
			}
		});
		
		_newtw_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_Interview_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				Interview.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						interview.setAdapter(new InterviewAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				Interview.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						interview.setAdapter(new InterviewAdapter(list));
						swiperefreshlayout1.setRefreshing(false);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		Interview.addChildEventListener(_Interview_child_listener);
		
		_mathematics_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				mathematics.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						maths.setAdapter(new MathsAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				mathematics.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						maths.setAdapter(new MathsAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		mathematics.addChildEventListener(_mathematics_child_listener);
		
		_GT_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				GT.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						gtA.setAdapter(new GtAAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				GT.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						gtA.setAdapter(new GtAAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		GT.addChildEventListener(_GT_child_listener);
		
		_Eng_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				Eng.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						eng.setAdapter(new EngAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				Eng.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								list.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						loding_linear.setVisibility(View.GONE);
						swiperefreshlayout1.setRefreshing(false);
						eng.setAdapter(new EngAdapter(list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		Eng.addChildEventListener(_Eng_child_listener);
	}
	
	private void initializeLogic() {
		cel = Calendar.getInstance();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			int flags = getWindow().getDecorView().getSystemUiVisibility();
			
			flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
			
			getWindow().getDecorView().setSystemUiVisibility(flags);
			
			getWindow().setStatusBarColor(Color.WHITE);
			
		};
		textview3.setText(new SimpleDateFormat("dd MMMM").format(cel.getTime()));
		_removeScollBar(vscroll1);
		_removeScollBar(interview);
		_removeScollBar(maths);
		_removeScollBar(gtA);
		_removeScollBar(eng);
		if (getIntent().hasExtra("username")) {
			data.edit().putString("username", getIntent().getStringExtra("username")).commit();
		}
		if (data.contains("username")) {
			textview4.setText("Welcome, ".concat(data.getString("username", "")));
		} else {
			textview4.setText("Welcome, ".concat("Dear"));
		}
		English.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		textview0.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)25, (int)0, 0xFFFFFFFF, 0xFFFFFFFF));
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
		textview0.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 0);
		math.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 0);
		gt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 0);
		English.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 0);
		textview6.setTextColor(0xFFFFFFFF);
		textview6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF263238));
		math.setTextColor(0xFF546E7A);
		math.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		gt.setTextColor(0xFF546E7A);
		gt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		English.setTextColor(0xFF546E7A);
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			content1_linear.setVisibility(View.VISIBLE);
			network_linear.setVisibility(View.GONE);
		} else {
			content1_linear.setVisibility(View.GONE);
			network_linear.setVisibility(View.VISIBLE);
		}
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				if (SketchwareUtil.isConnected(getApplicationContext())) {
					sim = 0;
					content1_linear.setVisibility(View.VISIBLE);
					network_linear.setVisibility(View.GONE);
					swiperefreshlayout1.setRefreshing(true);
				} else {
					content1_linear.setVisibility(View.GONE);
					network_linear.setVisibility(View.VISIBLE);
					swiperefreshlayout1.setRefreshing(false);
				}
			}
		});
		interview.setVisibility(View.VISIBLE);
		maths.setVisibility(View.GONE);
		gtA.setVisibility(View.GONE);
		eng.setVisibility(View.GONE);
	}
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _setViewHeight(final View _view, final double _height) {
		_view.getLayoutParams().height=(int)(_height);
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _clickAnim(final View _view) {
		_clickAnimation(_view);
	}
	
	
	public void _roundedCorners(final View _view, final double _one, final double _two, final double _three, final double _four, final String _color, final double _stroke, final String _stColor, final double _num, final String _NOTES) {
		Double left_top = _one;
		Double right_top = _two;
		Double right_bottom = _three;
		Double left_bottom = _four;
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		s.setCornerRadii(new float[] {left_top.floatValue(),left_top.floatValue(), right_top.floatValue(),right_top.floatValue(), left_bottom.floatValue(),left_bottom.floatValue(), right_bottom.floatValue(),right_bottom.floatValue()});
		s.setColor(Color.parseColor(_color));
		s.setStroke((int)_stroke, Color.parseColor(_stColor));
		_view.setBackground(s);
		_view.setElevation((int)_num);
	}
	
	public class InterviewAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public InterviewAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.lists, null);
			}
			
			final LinearLayout mbg = _view.findViewById(R.id.mbg);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout shim_lyt = _view.findViewById(R.id.shim_lyt);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout inshim = _view.findViewById(R.id.inshim);
			final com.facebook.shimmer.ShimmerFrameLayout shim1 = _view.findViewById(R.id.shim1);
			final com.facebook.shimmer.ShimmerFrameLayout shim2 = _view.findViewById(R.id.shim2);
			final com.facebook.shimmer.ShimmerFrameLayout shim3 = _view.findViewById(R.id.shim3);
			final com.facebook.shimmer.ShimmerFrameLayout shim4 = _view.findViewById(R.id.shim4);
			final com.facebook.shimmer.ShimmerFrameLayout shim5 = _view.findViewById(R.id.shim5);
			final com.facebook.shimmer.ShimmerFrameLayout shim6 = _view.findViewById(R.id.shim6);
			
			if (sim == 0) {
				linear1.setVisibility(View.GONE);
				shim_lyt.setVisibility(View.VISIBLE);
				tsim = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								linear1.setVisibility(View.VISIBLE);
								shim_lyt.setVisibility(View.GONE);
								sim = 1;
							}
						});
					}
				};
				_timer.schedule(tsim, (int)(1000));
			} else {
				linear1.setVisibility(View.VISIBLE);
				shim_lyt.setVisibility(View.GONE);
			}
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			imageview1.setImageResource(R.drawable.sub_2);
			textview4.setText(_data.get((int)_position).get("title").toString());
			textview5.setText(_data.get((int)_position).get("subject").toString());
			textview3.setText(_data.get((int)_position).get("que").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), WebviewActivity.class);
					i.putExtra("url", _data.get((int)_position).get("url").toString());
					startActivity(i);
				}
			});
			shim1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
			shim2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			_setViewHeight(swiperefreshlayout1, (list.size() - 1) * SketchwareUtil.getDip(getApplicationContext(), (int)(100)));
			_roundedCorners(linear1, 26, 26, 26, 26, "#FFFFFF", 2, "#212121", 3, "");
			_clickAnim(linear1);
			
			return _view;
		}
	}
	
	public class MathsAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public MathsAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.lists, null);
			}
			
			final LinearLayout mbg = _view.findViewById(R.id.mbg);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout shim_lyt = _view.findViewById(R.id.shim_lyt);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout inshim = _view.findViewById(R.id.inshim);
			final com.facebook.shimmer.ShimmerFrameLayout shim1 = _view.findViewById(R.id.shim1);
			final com.facebook.shimmer.ShimmerFrameLayout shim2 = _view.findViewById(R.id.shim2);
			final com.facebook.shimmer.ShimmerFrameLayout shim3 = _view.findViewById(R.id.shim3);
			final com.facebook.shimmer.ShimmerFrameLayout shim4 = _view.findViewById(R.id.shim4);
			final com.facebook.shimmer.ShimmerFrameLayout shim5 = _view.findViewById(R.id.shim5);
			final com.facebook.shimmer.ShimmerFrameLayout shim6 = _view.findViewById(R.id.shim6);
			
			if (sim == 0) {
				linear1.setVisibility(View.GONE);
				shim_lyt.setVisibility(View.VISIBLE);
				tsim = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								linear1.setVisibility(View.VISIBLE);
								shim_lyt.setVisibility(View.GONE);
								sim = 1;
							}
						});
					}
				};
				_timer.schedule(tsim, (int)(1000));
			} else {
				linear1.setVisibility(View.VISIBLE);
				shim_lyt.setVisibility(View.GONE);
			}
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			imageview1.setImageResource(R.drawable.img);
			textview4.setText(_data.get((int)_position).get("title").toString());
			textview5.setText(_data.get((int)_position).get("subject").toString());
			textview3.setText(_data.get((int)_position).get("que").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), WebviewActivity.class);
					i.putExtra("url", _data.get((int)_position).get("url").toString());
					startActivity(i);
				}
			});
			shim1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
			shim2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			_setViewHeight(swiperefreshlayout1, (list.size() - 1) * SketchwareUtil.getDip(getApplicationContext(), (int)(100)));
			_roundedCorners(linear1, 26, 26, 26, 26, "#FFFFFF", 2, "#212121", 3, "");
			_clickAnim(linear1);
			
			return _view;
		}
	}
	
	public class GtAAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public GtAAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.lists, null);
			}
			
			final LinearLayout mbg = _view.findViewById(R.id.mbg);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout shim_lyt = _view.findViewById(R.id.shim_lyt);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout inshim = _view.findViewById(R.id.inshim);
			final com.facebook.shimmer.ShimmerFrameLayout shim1 = _view.findViewById(R.id.shim1);
			final com.facebook.shimmer.ShimmerFrameLayout shim2 = _view.findViewById(R.id.shim2);
			final com.facebook.shimmer.ShimmerFrameLayout shim3 = _view.findViewById(R.id.shim3);
			final com.facebook.shimmer.ShimmerFrameLayout shim4 = _view.findViewById(R.id.shim4);
			final com.facebook.shimmer.ShimmerFrameLayout shim5 = _view.findViewById(R.id.shim5);
			final com.facebook.shimmer.ShimmerFrameLayout shim6 = _view.findViewById(R.id.shim6);
			
			if (sim == 0) {
				linear1.setVisibility(View.GONE);
				shim_lyt.setVisibility(View.VISIBLE);
				tsim = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								linear1.setVisibility(View.VISIBLE);
								shim_lyt.setVisibility(View.GONE);
								sim = 1;
							}
						});
					}
				};
				_timer.schedule(tsim, (int)(1000));
			} else {
				linear1.setVisibility(View.VISIBLE);
				shim_lyt.setVisibility(View.GONE);
			}
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			imageview1.setImageResource(R.drawable.sub_3);
			textview4.setText(_data.get((int)_position).get("title").toString());
			textview5.setText(_data.get((int)_position).get("subject").toString());
			textview3.setText(_data.get((int)_position).get("que").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), WebviewActivity.class);
					i.putExtra("url", _data.get((int)_position).get("url").toString());
					startActivity(i);
				}
			});
			shim1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
			shim2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			_setViewHeight(swiperefreshlayout1, (list.size() - 1) * SketchwareUtil.getDip(getApplicationContext(), (int)(100)));
			_roundedCorners(linear1, 26, 26, 26, 26, "#FFFFFF", 2, "#212121", 3, "");
			_clickAnim(linear1);
			
			return _view;
		}
	}
	
	public class EngAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public EngAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.lists, null);
			}
			
			final LinearLayout mbg = _view.findViewById(R.id.mbg);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout shim_lyt = _view.findViewById(R.id.shim_lyt);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout inshim = _view.findViewById(R.id.inshim);
			final com.facebook.shimmer.ShimmerFrameLayout shim1 = _view.findViewById(R.id.shim1);
			final com.facebook.shimmer.ShimmerFrameLayout shim2 = _view.findViewById(R.id.shim2);
			final com.facebook.shimmer.ShimmerFrameLayout shim3 = _view.findViewById(R.id.shim3);
			final com.facebook.shimmer.ShimmerFrameLayout shim4 = _view.findViewById(R.id.shim4);
			final com.facebook.shimmer.ShimmerFrameLayout shim5 = _view.findViewById(R.id.shim5);
			final com.facebook.shimmer.ShimmerFrameLayout shim6 = _view.findViewById(R.id.shim6);
			
			if (sim == 0) {
				linear1.setVisibility(View.GONE);
				shim_lyt.setVisibility(View.VISIBLE);
				tsim = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								linear1.setVisibility(View.VISIBLE);
								shim_lyt.setVisibility(View.GONE);
								sim = 1;
							}
						});
					}
				};
				_timer.schedule(tsim, (int)(1000));
			} else {
				linear1.setVisibility(View.VISIBLE);
				shim_lyt.setVisibility(View.GONE);
			}
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_regular.ttf"), 1);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/product_sans_.ttf"), 0);
			imageview1.setImageResource(R.drawable.sub_1);
			textview4.setText(_data.get((int)_position).get("title").toString());
			textview5.setText(_data.get((int)_position).get("subject").toString());
			textview3.setText(_data.get((int)_position).get("que").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), WebviewActivity.class);
					i.putExtra("url", _data.get((int)_position).get("url").toString());
					startActivity(i);
				}
			});
			shim1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
			shim2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			shim6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE0E0E0));
			_setViewHeight(swiperefreshlayout1, (list.size() - 1) * SketchwareUtil.getDip(getApplicationContext(), (int)(100)));
			_roundedCorners(linear1, 26, 26, 26, 26, "#FFFFFF", 2, "#212121", 3, "");
			_clickAnim(linear1);
			
			return _view;
		}
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