package id.sch.smktelkom_mlg.tugas01.xiirpl3006.pendaftaran_ekstrakulikuler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ednama;
    Spinner spkelas;
    RadioGroup rgjk;
    CheckBox cbbsk, cbps, cbfo, cbpr, cbtf;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ednama = (EditText) findViewById(R.id.editTextnama);
        spkelas = (Spinner) findViewById(R.id.spinnerkelas);
        rgjk = (RadioGroup) findViewById(R.id.radiogroupjk);
        cbbsk = (CheckBox) findViewById(R.id.checkBoxbskt);
        cbps = (CheckBox) findViewById(R.id.checkBoxps);
        cbfo = (CheckBox) findViewById(R.id.checkBoxfo);
        cbpr = (CheckBox) findViewById(R.id.checkBoxpr);
        cbtf = (CheckBox) findViewById(R.id.checkBoxtfsr);
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
        String hasil = null;
        if (rgjk.getCheckedRadioButtonId() != -1){
            RadioButton rb = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil==null){
            tvhasil.setText("Anda belum mengisi jenis kelamin");
        }
        else {
            String ekskul = "\t Ekstrakulikuler yang Dipilih \t\n";
            int startlen = ekskul.length();
            if (cbbsk.isChecked()) ekskul += "\t\t - " +cbbsk.getText() + "\n";
            if (cbps.isChecked()) ekskul += "\t\t - " +cbps.getText() + "\n";
            if (cbfo.isChecked()) ekskul += "\t\t - " +cbfo.getText() + "\n";
            if (cbpr.isChecked()) ekskul += "\t\t - " +cbpr.getText() + "\n";
            if (cbtf.isChecked()) ekskul += "\t\t - " +cbtf.getText() + "\n";
            if (ekskul.length() == startlen) {
                tvhasil.setText("Anda belum memilih ekskul");
            }
            else {
                builder.append("Nama : " + nama + "\n");
                builder.append("Kelas : ");
                builder.append(spkelas.getSelectedItem().toString() + "\n");
                builder.append("Jenis kelamin : " + hasil + "\n");
                builder.append(ekskul + "\n");
                tvhasil.setText(builder);
            }
        }
    }
}
