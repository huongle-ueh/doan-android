package com.example.uehnews;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

public class DisplayActivity extends AppCompatActivity {

    ImageView image;
    TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        image = findViewById(R.id.dspl_image);
        title = findViewById(R.id.dspl_title);
        content = findViewById(R.id.dspl_content);

        Glide.with(this)
                .load(getIntent().getStringExtra("image"))
                .into(image);
        title.setText(getIntent().getStringExtra("title"));
        content.setText(Html.fromHtml(getIntent().getStringExtra("content") + "<p>Chinese airlines undertaking the biggest hiring drives in more than three years as travel rebounds are facing a deluge of applicants for cabin crew roles as fresh university graduates turn to the relatively high-paying career in a bleak job market. In contrast to Western countries, where cabin crew roles are relatively low-paid and mostly do not require a university degree, becoming a flight attendant in China typically requires a bachelor's degree and preferably passing a challenging government-administrated English test.</p>\n" +
                "\n" +
                "<p>During the pandemic, the total number of flight attendants in China fell by around 11,000, or an 11% drop from the pre-pandemic level of 108,955 in 2019, according to data from the Civil Aviation Administration of China (CAAC), due to attrition rather than the widespread layoffs seen in the West.</p>\n" +
                "\n" +
                "<p>Carriers including Xiamen Airlines, China Southern Airlines and Spring Airlines are now on a hiring spree as domestic travel recovers and they plan to resume flights to popular international destinations.</p>\n" +
                "\n" +
                "<p>They can pick from an overwhelming number of applicants at a time when a record 11.58 million college graduates are about to enter one of the country's worst job markets in decades. The gloomy global economic outlook has weakened export demand and companies in sectors like technology, education and property are cutting staff.</p>\n" +
                "\n" +
                "<p>Hainan Airlines, which plans to hire more than 1,000 flight attendants this year, has already received more than 20,000 applications, it told Reuters.</p>\n" +
                "\n" +
                "<p>Its job fair held in Jinan in February attracted 900 candidates and the company hired just 60 people, meaning a selection rate of around 6%.</p>\n" +
                "\n" +
                "<p>China Southern, which plans to hire 3,000 cabin crew this year, said it already had more than seven times as many applicants by the end of December.</p>\n" +
                "\n" +
                "<p>Before the pandemic, around 10% of cabin crew applications were typically successful, industry experts said.</p>\n" +
                "\n" +
                "<p>&quot;There have always been a large number of young girls and boys who want to do this job, as the income is not bad, usually between 10,000 ($1,454) and 20,000 yuan a month, and it is fun, allowing you to fly around the world,&quot; said Li Hanming, an independent expert on China's aviation industry.</p>\n" +
                "\n" +
                "<p>In 2021, only 6.1% of fresh college graduates earned more than 10,000 yuan a month, the Global Times reported in February, citing education consulting and research institute MyCOS.</p>\n" +
                "\n" +
                "<p>Wang Shenbo, who applied for a flight attendant role at Hainan Airlines, said the majority of his classmates were continuing to study for a master's degree in hopes of getting even better paid jobs.</p>\n" +
                "\n" +
                "<p>&quot;Some of them are not interested in the work of flight attendants, unlike me... and many of my classmates have found a job but are dissatisfied with the salary level,&quot; he told Reuters.</p>\n" +
                "\n" +
                "<p>High fares</p>\n" +
                "\n" +
                "<p>Despite the surge in job seekers, airlines may find it difficult to deploy new hires immediately because of year-long ground training courses, which could slow their efforts to boost capacity quickly and keep airfares high, Li said.</p>\n" +
                "\n" +
                "<p>&quot;Carriers have pretty bright forecast for 2024 so they need to hire crew members now, otherwise they will be short of hands next year,&quot; he added.</p>\n" +
                "\n" +
                "<p>China's domestic capacity surpassed 2019 levels from mid-March, but international flights have recovered to just 30% of pre-pandemic levels, according to data from flight tracking app Flight Master.</p>\n" +
                "\n" +
                "<p>As the peak summer season approaches, Chinese airlines are adding international capacity. Flag carrier Air China, for example, said it would return to pre-pandemic routes including Beijing-Rome, Beijing-Ho Chi Minh City and Chengdu-London.</p>\n" +
                "\n" +
                "<p>But for now the limited capacity has led to higher fares.</p>\n" +
                "\n" +
                "<p>&quot;I paid 18,000 yuan for a one-way economy ticket to fly from Frankfurt to Beijing,&quot; said Jin Huo, a businessman, &quot;I used to pay a third (of that) for a round trip.&quot;</p>").toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
