package com.example.styleout12;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentUp extends Fragment {

    View uView;
    private RecyclerView myRecyclerViewUp;
    private List<Up> lstUp;

    private BackgroundColorChanger mColor = new BackgroundColorChanger();
    // Declare our View variables
    private Button mNext;
    private LinearLayout mLayout;

    public static final String[] titles = new String[] {"Apricot", "AshGray", "Azure", "Beige", "Black", "Blue", "BlueGray", "BlueJeans",
            "BottleGreen", "Celeste", "Coral", "DarkGreen", "Gold", "Gray", "Green",
            "GreenBlue", "Lavender", "LightBlue", "Magenta", "MidnightBlue", "MintGreen",
            "NavyBlue", "OceanBlue", "OceanGreen", "Olive", "Orange", "Pink", "Red", "Rose",
            "Sand", "Scarlet", "Silver", "Tangerine", "Turquoise", "Violet", "White", "Yellow"};

    public static final Integer[] images = {
            R.drawable.apricot, R.drawable.ashgray, R.drawable.azure, R.drawable.beige,
            R.drawable.black, R.drawable.blue, R.drawable.bluegray, R.drawable.bluejeans,
            R.drawable.bottlegreen, R.drawable.celeste, R.drawable.coral, R.drawable.darkgreen,
            R.drawable.gold, R.drawable.gray, R.drawable.green, R.drawable.greenblue,
            R.drawable.lavender, R.drawable.lightblue, R.drawable.magenta, R.drawable.midnightblue,
            R.drawable.mintgreen, R.drawable.navyblue, R.drawable.oceanblue, R.drawable.oceangreen,
            R.drawable.olive, R.drawable.orange, R.drawable.pink, R.drawable.red,
            R.drawable.rose, R.drawable.sand, R.drawable.scarlet, R.drawable.silver,
            R.drawable.tangerine, R.drawable.turquoise, R.drawable.violet, R.drawable.white,
            R.drawable.yellow};

    Spinner spinner;
    List<RowItem> rowItems;

    Spinner fabricSelect;

    ImageView changeImage;
    Button buttonNext;

    public FragmentUp() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        uView = inflater.inflate(R.layout.up_fragment, container, false);
        myRecyclerViewUp = (RecyclerView) uView.findViewById( R.id.up_recyclerview );
        RecyclerViewAdapterUp recyclerViewAdapterUp = new RecyclerViewAdapterUp( getContext(), lstUp );
        myRecyclerViewUp.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myRecyclerViewUp.setAdapter( recyclerViewAdapterUp );

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem( images[i], titles[i] );
            rowItems.add( item );
        }

        spinner = (Spinner) uView.findViewById(R.id.upspinner);
        ColorSelectorAdapter adapter = new ColorSelectorAdapter( getActivity(),
                R.layout.spinner_up, R.id.textView, rowItems);
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemvalue = parent.getItemAtPosition( position ).toString();
                Toast.makeText( getActivity(), "SELECTED" + itemvalue, Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        fabricSelect = (Spinner) uView.findViewById(R.id.fabricupselect);
        List<String> list = new ArrayList<>();
        // lightweight fabrics
        list.add("Cotton"); list.add("Silk");
        // mesh fabrics
        list.add("Cape"); list.add("Lace"); list.add("Tarlatan");
        // medium weight fabrics
        list.add("Cashmere"); list.add("Crepe");list.add("Flannel"); list.add("Poplin"); list.add("RawSilk"); list.add("Sateen");
        // piled fabrics
        list.add("BrushDenim");list.add("Fur"); list.add("Microfiber"); list.add("Suede"); list.add("Velvet");
        // heavy weight fabrics
        list.add("Canvas"); list.add("Denim"); list.add("Tartan"); list.add("Upholstery");
        // Shiny glossy fabrics
        list.add("Satin"); list.add("Silk"); list.add("PolishedCotton");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fabricSelect.setAdapter(adapter1);
        fabricSelect.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        // ID
        mNext = (Button) uView.findViewById(R.id.color_background_next);
        mLayout = (LinearLayout) uView.findViewById(R.id.provabackground);

        // when next is click then do the following
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = mColor.getColor();

                //Update the screen with a color
                mLayout.setBackgroundColor(color);
                mNext.setTextColor(color);
            }
        };
        mNext.setOnClickListener(listener);

        return uView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        lstUp = new ArrayList<>();
        lstUp.add(new Up( R.drawable.camicia_collo ));
        lstUp.add( new Up( R.drawable.camicia_collo_taschino ));
        lstUp.add( new Up( R.drawable.camicia_nocollo ));
        lstUp.add( new Up( R.drawable.camicia_nocollo_taschino ));
        lstUp.add( new Up( R.drawable.camici_manichecorte_collo ));
        lstUp.add( new Up( R.drawable.camicia_manichecorte_collo_taschino ));
        lstUp.add( new Up( R.drawable.polo_collo ));
        lstUp.add( new Up( R.drawable.polo_collo_taschino ));
        lstUp.add( new Up( R.drawable.polo_collo_orli ));
        lstUp.add( new Up( R.drawable.polo_collo_orli_taschino ));
        lstUp.add( new Up( R.drawable.tshirt_taschino_nocollo ));
        lstUp.add( new Up( R.drawable.tshirt_taschino ));

    }
}