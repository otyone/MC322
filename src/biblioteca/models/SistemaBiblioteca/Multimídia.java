package biblioteca.models.SistemaBiblioteca;

import biblioteca.models.ItemMulti.CDAudio;

import biblioteca.models.ItemMulti.DVD;

import biblioteca.models.ItemMulti.Outros;

public class Multimídia {
	static class Audio{
		private CDAudio audio;
		public Audio(CDAudio audio) {
			this.audio = audio;
		}
		public CDAudio getAudio() {
			return audio;
		}
		public void setAudio(CDAudio audio) {
			this.audio = audio;
		}
	}
	static class Video{	
		private DVD video;
		public Video(DVD video) {
			this.video = video;
		}
		public DVD getVideo() {
			return video;
		}
		public void setVideo(DVD video) {
			this.video = video;
		}
	}
	static class Software{
		private Outros software;
		public Software(Outros software) {
			this.software = software;
		}
		public Outros getSoftware() {
			return software;
		}
		public void setSoftware(Outros software) {
			this.software = software;
		}
		
	}
}