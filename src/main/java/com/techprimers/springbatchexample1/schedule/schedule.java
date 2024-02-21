package com.techprimers.springbatchexample1.schedule;

import com.techprimers.springbatchexample1.batch.DBWriter;
import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.repository.UserRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableScheduling
@Component
public class schedule {
    @Autowired
    private UserRepository userRepository;

    public schedule(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void getDateTimeCurrent() throws Exception
    {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Ngày giờ hiện tại: " + currentDateTime.format(formatter));
    }
    @Scheduled(cron = "0/15 * * * * ?")
    public void save() throws Exception
    {
        User user = new User(7,"Trrrr","Operations",6000);
        userRepository.save(user);
        System.out.println("Save success");
    }
}
