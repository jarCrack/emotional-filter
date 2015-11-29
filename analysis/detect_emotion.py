import numpy as np
import pandas
import sys




if(len(sys.argv)<2):
	print "Please input tag"
else:
	#print sys.argv[1]

	word=sys.argv[1]
	emotions=["pleased","excited","aroused","distressed","miserable","depressed","sleepy","relaxed"]

	"aroused,distressed,miserable,depressed,sleepy,relaxed,pleased,excited"

	#scan csv

	df=pandas.read_csv("ratings.csv")

	#print df
	entry=df[df["Word"]==word]
	valence=entry["V.Mean.Sum"]
	arousal=entry["A.Mean.Sum"]

	# compute degree
	arousal-=5.
	valence-=5.

	print float(arousal)
	print float(valence)

	deg=np.array(map(lambda x:360+x if x<0 else x,np.arctan2(arousal,valence)*360/(2*np.pi)))[0]
	#print deg

	# compute value with smallest angular distance

	difs=abs(np.arange(0,360,45)-float(deg))
	best=difs.argmin()
	if(360.-float(deg)<difs.min()):
	    best=0

	#print difs

	print emotions[best]

	#print np.array(emotions.keys())-deg)


