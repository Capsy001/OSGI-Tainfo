package trainidpublisher;

import models.Train;

public interface TrainIDPublish {

	public Train publishTID(String origin, String dest);
	
	public Train publishTrain(int tid);
}
