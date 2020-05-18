package tn.medtech.recruitmentsystemapp.ui;
/*
* This activity contains the common form that any user should pass by.
*
* */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import tn.medtech.recruitmentsystemapp.R;
import tn.medtech.recruitmentsystemapp.api.models.Applicant;
import tn.medtech.recruitmentsystemapp.api.models.Recruiter;

public class GeneralRegisterActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_register);
        Bundle intent = getIntent().getExtras();
        int role = intent.getInt("role");
        System.out.print(role);
        firstName = findViewById(R.id.firstNameFld);
        lastName = findViewById(R.id.lastNameFld);
        email = findViewById(R.id.emailFld);
        password = findViewById(R.id.passwordFld);
        next = findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(role == 1) {
                    // Create a recruiter
                    Recruiter recruiter = new Recruiter(
                        firstName.getText().toString(),
                            lastName.getText().toString(),
                            email.getText().toString(),
                            null,
                            password.getText().toString(),
                            null
                    );
                    Intent finalRecruiterIntent = new Intent(GeneralRegisterActivity.this, RecruiterRegisterActivity.class);
                    finalRecruiterIntent.putExtra("recruiterObject", new Gson().toJson(recruiter));
                    startActivity(finalRecruiterIntent);

                } else {
                    // Create an applicant
                    Applicant applicant = new Applicant(
                            firstName.getText().toString(),
                            lastName.getText().toString(),
                            email.getText().toString(),
                            null,
                            password.getText().toString(),
                            null
                            );
                    Intent finalApplicantInent = new Intent(GeneralRegisterActivity.this, ApplicantRegisterActivity.class);
                    finalApplicantInent.putExtra("applicantObject", new Gson().toJson(applicant));
                    startActivity(finalApplicantInent);
                }
            }
        });

    }
}
