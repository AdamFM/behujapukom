package com.fikri.katakana.dakuon;

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

public class DakuonZ extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
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

	            mediaPlayer = MediaPlayer.create(this, R.raw.za);
	        }
	        else if (arg == 1) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.ji);
	        }
	        else if (arg == 2) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.zu);
	        }
	        else if (arg == 3) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.ze);
	        }
	        else if (arg == 4) {
	        	mediaPlayer = MediaPlayer.create(this, R.raw.zo);
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
	        mDrawer = MenuDrawer.attach(DakuonZ.this);
			mDrawer.setMenuView(R.layout.menudrawerdakuon);
			mDrawer.setContentView(R.layout.activity_dakuon);
			
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
			
			Button btnZ = (Button)findViewById(R.id.btnZ);
			btnZ.setBackgroundColor(color);
			btnZ.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnD = (Button)findViewById(R.id.btnD);
			btnD.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), DakuonD.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnG = (Button)findViewById(R.id.btnG);
			btnG.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), Dakuon.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnB = (Button)findViewById(R.id.btnB);
			btnB.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent k = new Intent().setClass(getApplicationContext(), DakuonB.class);
					startActivity(k);finish();
					overridePendingTransition  (R.animator.right_slide_out, R.animator.right_slide_in);
					
					mDrawer.closeMenu(true);
				}
			});
			
			Button btnP = (Button)findViewById(R.id.btnP);
			btnP.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent t = new Intent().setClass(getApplicationContext(), DakuonP.class);
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
	       
	         fragments.add(Fragment.instantiate(this, Kata_Za.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Zi.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Zu.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Ze.class.getName()));
	         fragments.add(Fragment.instantiate(this, Kata_Zo.class.getName()));
	         
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
	        
	    	DakuonZ.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab6").setIndicator("ZA"));
	        DakuonZ.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab7").setIndicator("JI"));
	        DakuonZ.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab8").setIndicator("ZU"));
	        DakuonZ.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab9").setIndicator("ZE"));
	        DakuonZ.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab10").setIndicator("ZO"));
	        
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
	    private static void AddTab(DakuonZ activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
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
