package sample.digitalia.be.contextthemewrapperissuesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewGroup container = (ViewGroup) findViewById(R.id.inner_layout_container);
		getSupportFragmentManager().beginTransaction().add(R.id.inner_layout_container, new BlankFragment1()).commit();

	}

	public void switchFragment(int which){
		switch (which){
			case 1:
				getSupportFragmentManager().beginTransaction().replace(R.id.inner_layout_container, new BlankFragment1()).commit();
				break;
			case 2:
				getSupportFragmentManager().beginTransaction().replace(R.id.inner_layout_container, new BlankFragment2()).commit();
				break;
		}
	}
}
