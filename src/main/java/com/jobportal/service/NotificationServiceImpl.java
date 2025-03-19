package com.jobportal.service;

import java.time.LocalDateTime; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.NotificationDTO;
import com.jobportal.dto.NotificationStatus;
import com.jobportal.entity.Notification;
import com.jobportal.exception.JobPortalException;
import com.jobportal.repository.NotificationRepository;
import com.jobportal.utility.Utilities;

@Service ("notificationService")
public class NotificationServiceImpl  implements NotificationService{

	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public void sendNotification(NotificationDTO notificationDTO) throws JobPortalException {
		// TODO Auto-generated method stub
		notificationDTO.setId(Utilities.getNextSequence("notification"));
	notificationDTO.setStatus(NotificationStatus.UNREAD);
	
		notificationDTO.setTimestamp(LocalDateTime.now());
	notificationRepository.save(notificationDTO.toEntity());
	}

	@Override
	public List<Notification> getUnreadNotifications(Long userId) {
		// TODO Auto-generated method stub
		return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
	}

	@Override
	public void readNotification(Long id) throws JobPortalException {
		// TODO Auto-generated method stub
		Notification noti = notificationRepository.findById(id).orElseThrow(()->new JobPortalException("No Notification found"));
		
		noti.setStatus(NotificationStatus.READ);
		notificationRepository.save(noti);
	}
}
