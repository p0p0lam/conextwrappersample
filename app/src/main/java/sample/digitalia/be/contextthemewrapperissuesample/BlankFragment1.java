package sample.digitalia.be.contextthemewrapperissuesample;


import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Custom inner layout inflation with a specific theme
        ContextThemeWrapper wrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_Kangaroo_NoActionBar_Datacenter);
        View view = LayoutInflater.from(wrapper).inflate(R.layout.fragment_blank_fragment1, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.app_bar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        Button button = (Button) view.findViewById(R.id.switch_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().switchFragment(2);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getActivity().getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color

            window.setStatusBarColor(getThemePrimaryDarkColor(wrapper.getTheme()));
        }
        return view;
    }

    public static int getThemePrimaryDarkColor (final Resources.Theme theme) {
        final TypedValue value = new TypedValue();
        theme.resolveAttribute(R.attr.colorPrimaryDark, value, true);
        return value.data;
    }

    private MainActivity getMainActivity(){
        return (MainActivity) getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        getMainActivity().getSupportActionBar().setTitle("Fragment 1");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment1_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
