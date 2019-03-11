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

import org.measure.platform.core.data.api.IAnalysisCardService;
import org.measure.platform.core.data.api.IMeasureViewService;
import org.measure.platform.core.data.entity.AnalysisCard;
import org.measure.platform.core.data.entity.MeasureView;
import org.measure.platform.core.data.entity.Project;
import org.measure.platform.core.data.entity.ProjectAnalysis;
import org.measure.platform.core.data.querys.AnalysisCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing AnalysisCard.
 */
@Service
@Transactional
public class AnalysisCardServiceImpl implements IAnalysisCardService {
	private final Logger log = LoggerFactory.getLogger(AnalysisCardServiceImpl.class);

	@Inject
	private AnalysisCardRepository analysisRepository;

	@Inject
	private IMeasureViewService measureViewService;

	@Override
	public AnalysisCard save(AnalysisCard card) {
		log.debug("Request to save AnalysisCard : {}", card);
		AnalysisCard result = analysisRepository.save(card);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnalysisCard> findAll() {
		List<AnalysisCard> result = analysisRepository.findAll();
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnalysisCard> findAllByProjectAnalysis(ProjectAnalysis projectAnalysis) {
		
		List<AnalysisCard> result = analysisRepository.findByProjectAnalysis(projectAnalysis);
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public AnalysisCard findOne(Long id) {
		log.debug("Request to get Phase : {}", id);
		AnalysisCard card = analysisRepository.findOne(id);
		return card;
	}

	@Override
	public void delete(Long id) {
		for (MeasureView view : measureViewService.findByAnalysisCard(id)) {
			measureViewService.delete(view.getId());
		}

		analysisRepository.delete(id);
	}

	@Override
	public List<AnalysisCard> findAllByProject(Project project) {
		return analysisRepository.findByProject(project);
	}

}
