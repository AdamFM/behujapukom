package com.fikri.katakana.gojuon;

import java.util.List;
import java.util.Vector;
import com.fikri.behujap.PageAdapter;
import com.fikri.behujap.R;
import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;

public class GojuonN extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
	  private TabHost mTabHost;
	  private ViewPager mViewPager;
	  private PageAdapter mPagerAdapter;
	  private MediaPlayer mediaPlayer;
	 
	    /**
	     *
	     * @author mwho
	     * Maintains extrinsic info of a tab's construct
	     */
	    
	    public void OnPause(){
	        try{
	            super.onPause();
	            mediaPlayer.pause();
	        }catch (Exception e){

	        }
	    }

	    private void playSound(int arg){
	        try{
	            if (mediaPlayer.isPlaying()) {
	                mediaPlayer.stop();
	                mediaPlayer.release();
	            }
	        }catch(Exception e){
	            Log.e("error", "blablabla");
	        }
	        if (arg == 0){

	            mediaPlayer = MediaPlayer.create(this, R.raw.na);
	        }
	        else if (arg == 1) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.ni);
	        }
	        else if (arg == 2) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.nu);
	        }
	        else if (arg == 3) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.ne);
	        }
	        else if (arg == 4) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.no);
	        }
	        else if (arg == 5) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.nn);
	        }
	        mediaPlayer.setLooping(false); // Set looping
	        mediaPlayer.start();
	    }
	    
	    
	    /**
	     * A simple factory that returns dummy views to the Tabhost
	     * @author mwho
	     */
	    class TabFactory implements TabContentFactory {
	 
	        private final Context mContext;
	 
	        /**
	         * @param context
	         */
	        public TabFactory(Context context) {
	            mContext = context;
	        }
	 
	        /** (non-Javadoc)
	         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
	         */
	        public View createTabContent(String tag) {
	            View v = new View(mContext);
	            v.setMinimumWidth(0);
	            v.setMinimumHeight(0);
	            return v;
	        }
	 
	    }
	    /** (non-Javadoc)
	     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
	     */
	    
	    MenuDrawer mDrawer;
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // Inflate the layout
	        //setContentView(R.layout.activity_gojuon);
	        // Initialise the TabHost
	        mDrawer = MenuDrawer.attach(GojuonN.this);
			mDrawer.setMenuView(R.layout.menudrawer);
			mDrawer.setContentView(R.layout.activity_gojuon);
	        
			Resources res = getResources();
			int color = res.getColor(R.color.greenb);
			
			playSound(0);
				
			Button menu = (Button)findViewById(R.id.btnMenu);
			menu.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mDrawer.openMenu(true);
					}
			});
			
			Button btnN = (Button)findViewById(R.id.btnN);
			btnN.setBackgroundColor(color);
			btnN.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mDrawer.closeMenu(true);
				}
			});
	        
	        Button btnk = (Button)findViewById(R.id.btnK);
			btnk.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), GojuonK.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					mDrawer.closeMenu(true);
				}
			});	
			
			Button btnS = (Button)findViewById(R.id.btnS);
			btnS.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent S = new Intent().setClass(getApplicationContext(), GojuonS.class);
					startActivity(S);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnT = (Button)findViewById(R.id.btnT);
			btnT.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), GojuonT.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnVokal = (Button)findViewById(R.id.btnVokal);
			btnVokal.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), Gojuon.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
	  
			Button btnH = (Button)findViewById(R.id.btnH);
			btnH.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), GojuonH.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnY = (Button)findViewById(R.id.btnY);
			btnY.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), GojuonY.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnR = (Button)findViewById(R.id.btnR);
			btnR.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), GojuonR.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnM = (Button)findViewById(R.id.btnM);
			btnM.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent T = new Intent().setClass(getApplicationContext(), GojuonM.class);
					startActivity(T);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
	        this.initialiseTabHostN(savedInstanceState);
	        if (savedInstanceState != null) {
	            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
	        }
	        // Intialise ViewPager
	        this.initialiseViewPagerN();        
	    }
	 
	    @Override
	    public void onBackPressed() {
	    	// TODO Auto-generated method stub
	    	super.onBackPressed();
	    	overridePendingTransition(R.animator.right_slide_in1, R.animator.right_slide_out1);
	    }
	    /** (non-Javadoc)
	     * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
	     */
	    protected void onSaveInstanceState(Bundle outState) {
	        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
	        super.onSaveInstanceState(outState);
	    }
	 

	    /**
	     * Initialise ViewPager
	     */
	    private void initialiseViewPagerN() {
	    	 List<Fragment> fragments = new Vector<Fragment>();
	       
	         fragments.add(Fragment.instantiate(this, Kata_Na.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Ni.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Nu.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Ne.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_No.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_N.class.getName()));
	         
	         this.mPagerAdapter  = new PageAdapter(getSupportFragmentManager(), fragments);
	         //
	         this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
	         this.mViewPager.setAdapter(this.mPagerAdapter);
	         this.mViewPager.setOnPageChangeListener(this);
	    }
	 
	    /**
	     * Initialise the Tab Host
	     */
	    private void initialiseTabHostN(Bundle args) {
	    	mTabHost = (TabHost)findViewById(android.R.id.tabhost);
	        mTabHost.setup();
	        
	    	GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab6").setIndicator("NA"));
	        
	        GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab7").setIndicator("NI"));
	        
	        GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab8").setIndicator("NU"));
	        
	        GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab9").setIndicator("NE"));
	        
	        GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab10").setIndicator("NO"));
	        
	        GojuonN.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab11").setIndicator("N"));
	        
	        mTabHost.setOnTabChangedListener(this);
	    }
	    /**
	     * Add Tab content to the Tabhost
	     * @param activity
	     * @param tabHost
	     * @param tabSpec
	     * @param clss
	     * @param args
	     */
	    private static void AddTab(GojuonN activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
	        // Attach a Tab view factory to the spec
	        tabSpec.setContent(activity.new TabFactory(activity));
	        tabHost.addTab(tabSpec);
	    }
	 
	    /** (non-Javadoc)
	     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
	     */
	    public void onTabChanged(String tag) {
	        //TabInfo newTab = this.mapTabInfo.get(tag);
	        int pos = this.mTabHost.getCurrentTab();
	        this.mViewPager.setCurrentItem(pos);
	    }
	 
	    /* (non-Javadoc)
	     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
	     */
	    @Override
	    public void onPageScrolled(int position, float positionOffset,
	            int positionOffsetPixels) {
	        // TODO Auto-generated method stub
	 
	    }
	 
	    /* (non-Javadoc)
	     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
	     */
	    @Override
	    public void onPageSelected(int position) {
	        // TODO Auto-generated method stub
	        this.mTabHost.setCurrentTab(position);
	        
	        if (position == 0) {
				playSound(0);
			}
	        
	        else if (position == 1) {
	    		playSound(1);
	    	}
	        
	        else if (position == 2) {
	    		playSound(2);
	    	}
	        
	        else if (position == 3) {
	    		playSound(3);
	    	}
	        
	        else if (position == 4) {
	    		playSound(4);
	    	}
	        else if (position == 5) {
	    		playSound(5);
	    	}
	    }
	 
	    /* (non-Javadoc)
	     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	     */
	    @Override
	    public void onPageScrollStateChanged(int state) {
	        // TODO Auto-generated method stub
	 
	    }
}
