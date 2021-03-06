package br.com.checker.emag.core;

import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import br.com.checker.emag.Occurrence;
import br.com.checker.emag.OccurrenceClassification;
import br.com.checker.emag.core.SpecificRecommendation.MultimediaRecommendation;

public class MultimediaEvaluation extends Evaluation{

	private MultimediaEvaluation(Source document) { super(document); }
	
	public static class MultimediaEvaluationBuilder extends EvaluationBuilder {
		
		@Override
		protected MultimediaEvaluation with(Source document) { return new MultimediaEvaluation(document); }
		
		@Override
		protected MultimediaEvaluation with(Source document,String url) { return new MultimediaEvaluation(document); }
		
		public SpecificRecommendation recommendation33() { return new EvaluationRecommendation33();}
		public SpecificRecommendation recommendation34() { return new EvaluationRecommendation34();}
		public SpecificRecommendation recommendation35() { return new EvaluationRecommendation35();}
		public SpecificRecommendation recommendation36() { return new EvaluationRecommendation36();}
		public SpecificRecommendation recommendation37() { return new EvaluationRecommendation37();}
		
	}
	
	protected static class EvaluationRecommendation33 extends MultimediaRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation33();}
	}
	
	protected static class EvaluationRecommendation34 extends MultimediaRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation34();}
	}
	
	protected static class EvaluationRecommendation35 extends MultimediaRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation35();}
	}
	
	protected static class EvaluationRecommendation36 extends MultimediaRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation36();}
	}
	
	protected static class EvaluationRecommendation37 extends MultimediaRecommendation{
		protected List<Occurrence> check() { return getEvaluation().checkRecommendation37();}
	}
	
	
	public List<Occurrence> check() {
		getOccurrences().clear();
		getOccurrences().addAll(checkRecommendation33());
		getOccurrences().addAll(checkRecommendation34());
		getOccurrences().addAll(checkRecommendation35());
		getOccurrences().addAll(checkRecommendation36());
		//O m�todo n�o � utilizado, porque requisi��o � valida��o humana (5.5.1 Anima��o � executada automaticamente sem op��es para pausar)
		//getOccurrences().addAll(checkRecommendation37());
		
		return getOccurrences();
	}
	
	
	
	private List<Occurrence> checkRecommendation33() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		
		for (Element video : getDocument().getAllElements("embed")){
			
			Attribute value = video.getAttributes().get("src");
			if (value != null){
				/*if (value.getValue().contains(".mp4")
						|| value.getValue().contains(".avi")
						|| value.getValue().contains(".flv")
						|| value.getValue().contains(".rmvb")
						|| value.getValue().contains(".WebM")
						|| value.getValue().contains(".Ogg")) {*/
					occurrences.add(this.buildOccurrence("5.1", false, video.toString(), video, "1"));
				//}
			
			}
		}
		
		for (Element video : this.getDocument().getAllElements("object")) {
				Attribute src = video.getAttributes().get("src");
				
				if (src != null)
				/*	if (value.getValue().contains(".mp4")
							|| value.getValue().contains(".avi")
							|| value.getValue().contains(".flv")
							|| value.getValue().contains(".rmvb")
							|| value.getValue().contains(".WebM")
							|| value.getValue().contains(".Ogg")) {*/
						occurrences.add(this.buildOccurrence("5.1", false, video.toString(), video, "1"));
					//}
				
		}
		
		for (Element video : this.getDocument().getAllElements("video")) {
			if(video.getTextExtractor().toString().isEmpty())
				occurrences.add(this.buildOccurrence("5.1", false, video.toString(), video, "1"));
		}
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation34() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		for (Element audio : getDocument().getAllElements("embed")){
			
			Attribute value = audio.getAttributes().get("src");
			if (value != null)
					occurrences.add(this.buildOccurrence("5.2", false, audio.toString(), audio, "1"));
		}
		
		for (Element audio : this.getDocument().getAllElements("object")) {
			Attribute src = audio.getAttributes().get("src");
			
			if (src != null)
				occurrences.add(this.buildOccurrence("5.2", false, audio.toString(), audio, "1"));
		}
		
		for (Element audio : getDocument().getAllElements("audio")) {
			if(audio.getTextExtractor().toString().isEmpty())
				occurrences.add(this.buildOccurrence("5.2", false, audio.toString(), audio, "1"));
		}
		
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation35() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		for (Element video : getDocument().getAllElements("embed")){
			
			Attribute src = video.getAttributes().get("src");
			if (src != null)
					occurrences.add(this.buildOccurrence("5.3", false, video.toString(), video, "1"));
			
			Attribute data = video.getAttributes().get("data");
			if (data != null)
					occurrences.add(this.buildOccurrence("5.3", false, video.toString(), video, "1"));
		}
		
		for (Element video : getDocument().getAllElements("object")){
			
			Attribute src = video.getAttributes().get("src");
			if (src != null)
				occurrences.add(this.buildOccurrence("5.3", false, video.toString(), video, "1"));
			
			Attribute data = video.getAttributes().get("data");
			if (data != null)
				occurrences.add(this.buildOccurrence("5.3", false, video.toString(), video, "1"));
			
		}	
		
		for (Element video : this.getDocument().getAllElements("video")) {
			if(video.getTextExtractor().toString().isEmpty())
				occurrences.add(this.buildOccurrence("5.3", false, video.toString(), video, "1"));
		}
		
	/*	for (Element video : getDocument().getAllElements("embed"))
			occurrences.add(this.buildOccurrence("5.3", true, video.toString(), video, "1"));*/
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation36() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		
		/*for (Element musica : getDocument().getAllElements("embed")){
			

			Attribute type = musica.getAttributes().get("type");
			if (type != null)
				if (type.getValue().contains("audio/x-mpeg")
						|| type.getValue().contains("audio/basic")
						|| type.getValue().contains("audio/wav")
						|| type.getValue().contains("audio/x-wav")
						|| type.getValue().contains("audio/x-pn-realaudio")
						|| type.getValue().contains("audio/x-ms-wma")
						|| type.getValue().contains("audio/ogg")
						|| type.getValue().contains("audio/mpeg")) {
			
				String autostart = musica.getAttributes().get("autoplay").getValue();
				String hidden = musica.getAttributes().get("hidden").getValue();
				
				if(autostart != null && hidden != null){
					if(autostart.equals("true") && hidden.equals("true"))
						occurrences.add(this.buildOccurrence("5.4", false, musica.toString(), musica, "1"));
				}
			}
		}
		
		for (Element musica : getDocument().getAllElements("object")){
			
			Attribute type = musica.getAttributes().get("type");
			if (type != null)
				if (type.getValue().contains("audio/x-mpeg")
						|| type.getValue().contains("audio/basic")
						|| type.getValue().contains("audio/wav")
						|| type.getValue().contains("audio/x-wav")
						|| type.getValue().contains("audio/x-pn-realaudio")
						|| type.getValue().contains("audio/x-ms-wma")
						|| type.getValue().contains("audio/ogg")
						|| type.getValue().contains("audio/mpeg")) {
			
					for (Element param : musica.getAllElements("param")){
				
						String name = param.getAttributes().getValue("name");
						String value = param.getAttributes().getValue("value");
						if(name != null && value != null){
							if(name.equals("autoplay") && value.equals("false"))
								occurrences.add(this.buildOccurrence("5.4", false, musica.toString(), musica, "1"));
					
							if(name.equals("autostart") && value.equals("0"))
								occurrences.add(this.buildOccurrence("5.4", false, musica.toString(), musica, "1"));
					}
				}	
			}
		}*/


		
		for (Element video : getDocument().getAllElements("embed")){
			
			Attribute value = video.getAttributes().get("src");
			Attribute data = video.getAttributes().get("data");
			
			if (value != null || data != null){
				/*if (value.getValue().contains(".mp4")
						|| value.getValue().contains(".avi")
						|| value.getValue().contains(".flv")
						|| value.getValue().contains(".rmvb")
						|| value.getValue().contains(".WebM")
						|| value.getValue().contains(".Ogg")) {*/
					occurrences.add(this.buildOccurrence("5.4", false, video.toString(), video, "1"));
				//}
			
			}
		}
		
		for (Element video : this.getDocument().getAllElements("object")) {
			Attribute src = video.getAttributes().get("src");
			Attribute data = video.getAttributes().get("data");
			
			if (src != null || data != null)
				/*	if (value.getValue().contains(".mp4")
							|| value.getValue().contains(".avi")
							|| value.getValue().contains(".flv")
							|| value.getValue().contains(".rmvb")
							|| value.getValue().contains(".WebM")
							|| value.getValue().contains(".Ogg")) {*/
						occurrences.add(this.buildOccurrence("5.4", false, video.toString(), video, "1"));
					//}
				
		}
		
		/*for (Element audio : this.getDocument().getAllElements("audio")) {
			if(audio.getTextExtractor().toString().isEmpty())
				occurrences.add(this.buildOccurrence("5.4", false, audio.toString(), audio, "1"));
		}*/
		
		for (Element audio : getDocument().getAllElements("audio")) {
			Attribute value = audio.getAttributes().get("controls");
			if (value == null)
					occurrences.add(this.buildOccurrence("5.4", false, audio.toString(), audio, "1"));
		}
		
		return occurrences;
	}
	
	private List<Occurrence> checkRecommendation37() {
		List<Occurrence> occurrences = new ArrayList<Occurrence>();
		/*for (Element video : getDocument().getAllElements("object")) {
			
			if (video.toString().contains("swf")) 
				occurrences.add(this.buildOccurrence("5.5", false, video.toString(), video, "1"));
		}*/
		
		occurrences.add(new Occurrence("5.5", false, getDocument().getFirstElement().toString(),OccurrenceClassification.MULTIMEDIA,"1"));
		
		
		return occurrences;
	}
	
	private Occurrence buildOccurrence(String code, boolean error,
			String tag, Element element,
			String criterio) {
		return super.buildOccurrence(code, error, tag, element, OccurrenceClassification.MULTIMEDIA,criterio);
	}
	
	private Occurrence buildOccurrence(String code, boolean error,
			String tag, Element element) {
		return super.buildOccurrence(code, error, tag, element, OccurrenceClassification.MULTIMEDIA);
	}
	
	public OccurrenceClassification type () { return OccurrenceClassification.MULTIMEDIA;}
}