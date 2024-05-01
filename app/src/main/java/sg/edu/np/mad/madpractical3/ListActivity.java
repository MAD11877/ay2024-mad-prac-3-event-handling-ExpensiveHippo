package sg.edu.np.mad.madpractical3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView ivIcon = findViewById(R.id.ivIcon);

        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // Instantiate AlertDialog (AD) builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                    // Set title of AD to be created
                    builder.setTitle("Profile");

                    // Set message to be displayed
                    builder.setMessage("MADness");

                    // Disallow user to cancel dialog through the 'X'
                    builder.setCancelable(false);

                    // Set positive button
                    builder.setPositiveButton("VIEW", (dialog, which) -> {
                        Intent viewProfile = new Intent(ListActivity.this, MainActivity.class);
                        startActivity(viewProfile);
                    });

                    // Set negative button
                    builder.setNegativeButton("CLOSE", (dialog, which) -> {
                        dialog.cancel();
                    });

                    // Create AD
                    AlertDialog prompt = builder.create();

                    // Show AD
                    prompt.show();
            }
        });
    }
}