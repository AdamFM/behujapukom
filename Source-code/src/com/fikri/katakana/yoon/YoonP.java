package com.fikri.katakana.yoon;

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

public class YoonP extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
	  private TabHost mTabHost;
	  private ViewPager mViewPager;
	  private PageAdapter mPagerAdapter;
	  private MediaPlayer mediaPlayer;
	    
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

	            mediaPlayer = MediaPlayer.create(this, R.raw.pya);
	        }
	        else if (arg == 1) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.pyu);
	        }
	        else if (arg == 2) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.pyo);
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
	        mDrawer = MenuDrawer.attach(YoonP.this);
			mDrawer.setMenuView(R.layout.menudraweryoon);
			mDrawer.setContentView(R.layout.activity_yoon);
	        
			playSound(0);
			
			Resources res = getResources();
			int color = res.getColor(R.color.greenb);
			
			Button menu = (Button)findViewById(R.id.btnMenu);
			menu.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mDrawer.openMenu(true);
					}
			});
			
			Button btnPy = (Button)findViewById(R.id.btnPy);
			btnPy.setBackgroundColor(color);
			btnPy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnSh = (Button)findViewById(R.id.btnSh);
			btnSh.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), YoonS.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnCh = (Button)findViewById(R.id.btnCh);
			btnCh.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), YoonC.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnNy = (Button)findViewById(R.id.btnNy);
			btnNy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonN.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnHy = (Button)findViewById(R.id.btnHy);
			btnHy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonH.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnMy = (Button)findViewById(R.id.btnMy);
			btnMy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonM.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnRy = (Button)findViewById(R.id.btnRy);
			btnRy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonR.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnGy = (Button)findViewById(R.id.btnGy);
			btnGy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonG.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnJ = (Button)findViewById(R.id.btnJ);
			btnJ.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonJ.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnBy = (Button)findViewById(R.id.btnBy);
			btnBy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), YoonB.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnKy = (Button)findViewById(R.id.btnKy);
			btnKy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), Yoon.class);
					startActivity(t);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			
			
	        this.initialiseTabHost(savedInstanceState);
	        if (savedInstanceState != null) {
	            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
	        }
	        // Intialise ViewPager
	        this.initialiseViewPager();        
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
	    private void initialiseViewPager() {
	    	 List<Fragment> fragments = new Vector<Fragment>();
	       
	         fragments.add(Fragment.instantiate(this, Kata_Pya.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Pyu.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Pyo.class.getName()));
	         
	         this.mPagerAdapter  = new PageAdapter(getSupportFragmentManager(), fragments);
	         //
	         this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
	         this.mViewPager.setAdapter(this.mPagerAdapter);
	         this.mViewPager.setOnPageChangeListener(this);
	    }
	 
	    /**
	     * Initialise the Tab Host
	     */
	    private void initialiseTabHost(Bundle args) {
	    	mTabHost = (TabHost)findViewById(android.R.id.tabhost);
	        mTabHost.setup();
	        
	    	YoonP.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab6").setIndicator("PYA"));
	        YoonP.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab7").setIndicator("PYU"));
	        YoonP.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab8").setIndicator("PYO"));
	        
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
	    private static void AddTab(YoonP activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
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
	    }
	 
	    /* (non-Javadoc)
	     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	     */
	    @Override
	    public void onPageScrollStateChanged(int state) {
	        // TODO Auto-generated method stub
	 
	    }
}
