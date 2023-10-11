package com.owner.ms.person.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class FirestoreConfig {

    @Value("${secure.json.path}")
    private String secureJsonPath;

    @Bean
    public Firestore firestore() throws Exception {
        FileInputStream serviceAccount = new FileInputStream(secureJsonPath);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        return FirestoreClient.getFirestore(FirebaseApp.initializeApp(options));
    }
}
