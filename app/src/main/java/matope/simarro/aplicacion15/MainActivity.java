package matope.simarro.aplicacion15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    miArrayAdapter<Tarea> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        String[] data = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        adaptador = new miArrayAdapter<Tarea>(this, DatosTareas.TAREAS);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tarea tareaActual = (Tarea) adaptador.getItem(position);
        String msg = "Elegiste la tarea:\n" + tareaActual.getNombre() + "-" + tareaActual.getHora();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}