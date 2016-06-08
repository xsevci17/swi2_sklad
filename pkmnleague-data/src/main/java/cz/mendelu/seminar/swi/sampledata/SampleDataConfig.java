package cz.mendelu.seminar.swi.sampledata;

import cz.mendelu.seminar.swi.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

@Configuration
@Import({ServiceConfiguration.class})
@ComponentScan(basePackages = "cz.mendelu.seminar.swi.sampledata")
public class SampleDataConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private SampleData sampleData;

    @PostConstruct
    public void dataLoading() {
        sampleData.loadData();
    }

}