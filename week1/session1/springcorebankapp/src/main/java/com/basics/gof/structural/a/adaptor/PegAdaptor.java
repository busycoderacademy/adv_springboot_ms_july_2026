package com.basics.gof.structural.a.adaptor;

// adaptoing roundpeg to square pag
	public class PegAdaptor extends SquarePeg  {
	
		private RoundPeg peg;
	
		public PegAdaptor(RoundPeg peg) {
			super();
			this.peg = peg;
		}
		
		public void insert(String str) {
			peg.insertTohole(str);
		}
	}