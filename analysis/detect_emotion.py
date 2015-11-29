import numpy as np
import pandas


word="lake"


#emotions={0.:"pleased",45.:"excited",90.:"aroused",135.:"distressed",180.:"miserable",225.:"depressed",270.:"sleepy",315.:"relaxed"}

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

deg=np.array(map(lambda x:360+x if x<0 else x,np.arctan2(arousal,valence)*360/(2*np.pi)))[0]
print deg

# compute value with smallest angular distance

difs=abs(np.arange(0,360,45)-float(deg))
best=difs.argmin()
if(360.-float(deg)<difs.min()):
    best=0

print difs

print emotions[best]

#print np.array(emotions.keys())-deg)


[["Word","V.Mean.Sum"]]
