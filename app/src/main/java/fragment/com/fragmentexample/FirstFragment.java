package fragment.com.fragmentexample;

        import android.app.Activity;
        import android.content.Context;
        import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;


public class FirstFragment extends Fragment
{
    String name;
    EditText editText;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        final  Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.fragment1);
        editText =(EditText)view.findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.getView().setBackgroundColor(Color.WHITE) ;

                FragmentManager fm = getFragmentManager();
                SecondFragment f2 = (SecondFragment) fm.findFragmentById(R.id.fragment2);
                name=editText.getText().toString();
                Log.d("lalitha", "onClick:"+name);
                if(f2 != null && f2.isInLayout())
                { try {
                    f2.setName(name);
                }catch(Exception e){e.printStackTrace();}
                }

                Activity activity = getActivity();

                if(activity != null)
                {
                    Toast.makeText(activity, "Saying Hi in Progress...", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;


    }
}
