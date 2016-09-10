package id.sch.smktelkom_mlg.tugas01.xiirpl3006.pendaftaran_ekstrakulikuler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ednama;
    Spinner spkelas;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ednama = (EditText) findViewById(R.id.editTextnama);
        spkelas = (Spinner) findViewById(R.id.spinnerkelas);
        tvhasil = (TextView) findViewById(R.id.textViewhasil);
        findViewById(R.id.buttonok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();

            }
        }
        );
    }

    private void doClick() {
        String nama = ednama.getText().toString();
        StringBuilder builder = new StringBuilder();
        builder.append("Nama : " + nama + "\n");
        builder.append("Kelas : ");
        builder.append(spkelas.getSelectedItem().toString() + "\n");
        tvhasil.setText(builder);
    }
}
