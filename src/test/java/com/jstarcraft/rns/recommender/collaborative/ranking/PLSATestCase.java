package com.jstarcraft.rns.recommender.collaborative.ranking;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.rns.configurator.Configuration;
import com.jstarcraft.rns.evaluator.ranking.AUCEvaluator;
import com.jstarcraft.rns.evaluator.ranking.MAPEvaluator;
import com.jstarcraft.rns.evaluator.ranking.MRREvaluator;
import com.jstarcraft.rns.evaluator.ranking.NDCGEvaluator;
import com.jstarcraft.rns.evaluator.ranking.NoveltyEvaluator;
import com.jstarcraft.rns.evaluator.ranking.PrecisionEvaluator;
import com.jstarcraft.rns.evaluator.ranking.RecallEvaluator;
import com.jstarcraft.rns.recommender.collaborative.ranking.PLSARecommender;
import com.jstarcraft.rns.task.RankingTask;

public class PLSATestCase {

	@Test
	public void testRecommender() throws Exception {
		Configuration configuration = Configuration.valueOf("recommendation/collaborative/ranking/plsa-test.properties");
		RankingTask job = new RankingTask(PLSARecommender.class, configuration);
		Map<String, Float> measures = job.execute();
		Assert.assertThat(measures.get(AUCEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.92598313F));
		Assert.assertThat(measures.get(MAPEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.45299292F));
		Assert.assertThat(measures.get(MRREvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.61743987F));
		Assert.assertThat(measures.get(NDCGEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.5469548F));
		Assert.assertThat(measures.get(NoveltyEvaluator.class.getSimpleName()), CoreMatchers.equalTo(16.236734F));
		Assert.assertThat(measures.get(PrecisionEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.34037304F));
		Assert.assertThat(measures.get(RecallEvaluator.class.getSimpleName()), CoreMatchers.equalTo(0.60055614F));
	}

}