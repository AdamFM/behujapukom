package com.fikri.hiragana.gojuon;

import java.util.List;
import java.util.Vector;
import net.simonvt.menudrawer.MenuDrawer;
import com.fikri.behujap.PageAdapter;
import com.fikri.behujap.R;
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
import android.widget.*;
import android.widget.TabHost.TabContentFactory;

public class GojuonH extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
 
    private TabHost mTabHost;
    private ViewPager mViewPager;
    private PageAdapter mPagerAdapter;
    private MediaPlayer mediaPlayer;
    int mCurrentSelectedPosition = 0;
    
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

            mediaPlayer = MediaPlayer.create(this, R.raw.ha);
        }
        else if (arg == 1) {
        	mediaPlayer = MediaPlayer.create(this, R.raw.hi);
        }
        else if (arg == 2) {
        	mediaPlayer = MediaPlayer.create(this, R.raw.hu);
        }
        else if (arg == 3) {
        	mediaPlayer = MediaPlayer.create(this, R.raw.he);
        }
        else if (arg == 4) {
        	mediaPlayer = MediaPlayer.create(this, R.raw.ho);
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
    
    MenuDrawer mDrawer, mDrawer2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout
        //setContentView(R.layout.activity_gojuon);
        // Initialise the TabHost
        mDrawer = MenuDrawer.attach(this);
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
		
		Button btnH = (Button)findViewById(R.id.btnH);
		btnH.setBackgroundColor(color);
		btnH.setOnClickListener(new OnClickListener() {
			
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
		
		Button btnN = (Button)findViewById(R.id.btnN);
		btnN.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent T = new Intent().setClass(getApplicationContext(), GojuonN.class);
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
  
		
		this.initialiseTabHost(savedInstanceState);
	    if (savedInstanceState != null) {
	        mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
	    }
		
        // Intialise ViewPager
        this.intialiseViewPager();        
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
    private void intialiseViewPager() {
 
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Hira_Ha.class.getName()));
        fragments.add(Fragment.instantiate(this, Hira_Hi.class.getName()));
        fragments.add(Fragment.instantiate(this, Hira_Fu.class.getName()));
        fragments.add(Fragment.instantiate(this, Hira_He.class.getName()));
        fragments.add(Fragment.instantiate(this, Hira_Ho.class.getName()));
        
        this.mPagerAdapter  = new PageAdapter(getSupportFragmentManager(), fragments);

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
        //TabInfo tabInfo = null;
        
        GojuonH.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("HA")); 
        GojuonH.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("HI")); 
        GojuonH.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("FU"));
        GojuonH.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab4").setIndicator("HE")); 
        GojuonH.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab5").setIndicator("HO")); 
        
        // Default to first tab
        //this.onTabChanged("Tab1");
        //
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
    private static void AddTab(GojuonH activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
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

