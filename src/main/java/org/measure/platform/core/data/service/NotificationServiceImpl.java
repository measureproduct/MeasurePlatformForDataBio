/*******************************************************************************
 * Copyright (C) 2019 Softeam
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.measure.platform.core.data.service;

import java.util.List;

import javax.inject.Inject;

import org.measure.platform.core.data.api.INotificationService;
import org.measure.platform.core.data.entity.Notification;
import org.measure.platform.core.data.entity.Project;
import org.measure.platform.core.data.querys.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Project.
 */
@Service
@Transactional
public class NotificationServiceImpl implements INotificationService {
    private final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Inject
    private NotificationRepository notificationRepository;
    
    /**
     * Save a project.
     * @param project
     * the entity to save
     * @return the persisted entity
     */
    public Notification save(Notification notification) {
        log.debug("Request to save Project : {}", notification);
        Notification result = notificationRepository.save(notification);
        return result;
    }

    /**
     * Get all the projects.
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Notification> findAll() {
        log.debug("Request to get all Projects");
        List<Notification> result = notificationRepository.findAll();
        return result;
    }

    /**
     * Get one project by id.
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Notification findOne(Long id) {
        log.debug("Request to get Project : {}", id);
        Notification notification = notificationRepository.findOne(id);
        return notification;
    }

    /**
     * Delete the  project by id.
     * @param id the id of the entity
     */
    public void delete(Long id) {
        notificationRepository.delete(id);
    }

    @Override
    public List<Notification> findAllByProject(Project project) {
        List<Notification> result = notificationRepository.findByProject(project);
        return result;
    }

    @Override
    public List<Notification> findNewByProject(Project project) {
        List<Notification> result = notificationRepository.findNewByProject(project);
        return result;
    }

}
