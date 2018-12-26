package tk.alltrue.listexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity implements AdapterView.OnItemLongClickListener{

    final String[] catNamesArray = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
            "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };

    private ArrayList<String> catNamesList = new ArrayList<>(Arrays.asList(catNamesArray));
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, catNamesList);

        setListAdapter(mAdapter);
        setContentView(R.layout.activity_list);
        getListView().setOnItemLongClickListener(this);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(),
                "You chose " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedItem = adapterView.getItemAtPosition(i).toString();
        mAdapter.remove(selectedItem);
        mAdapter.notifyDataSetChanged();

        Toast.makeText(getApplicationContext(),
                selectedItem + " removed.",
                Toast.LENGTH_SHORT).show();
        return true;
    }
}
