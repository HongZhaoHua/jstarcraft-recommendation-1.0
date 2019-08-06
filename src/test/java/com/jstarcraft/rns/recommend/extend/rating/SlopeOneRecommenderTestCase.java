package com.jstarcraft.rns.recommend.extend.rating;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.evaluate.rating.MAEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MPEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MSEEvaluator;
import com.jstarcraft.rns.configure.Configurator;
import com.jstarcraft.rns.recommend.extend.rating.SlopeOneRecommender;
import com.jstarcraft.rns.task.RatingTask;

public class SlopeOneRecommenderTestCase {

	@Test
	public void testRecommender() throws Exception {
		Configurator configuration = Configurator.valueOf("recommend/extend/slopeone-test.properties");
		RatingTask job = new RatingTask(SlopeOneRecommender.class, configuration);
		Map<String, Float> measures = job.execute();
		Assert.assertThat(measures.get(MAEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.6333391F));
		Assert.assertThat(measures.get(MPEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.9653521F));
		Assert.assertThat(measures.get(MSEEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.714156F));
	}

}