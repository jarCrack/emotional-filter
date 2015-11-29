from textblob import TextBlob as tb
from textblob.sentiments import NaiveBayesAnalyzer
import nltk

        

nltk.download()

blob=tb("I love this library",analyzer=NaiveBayesAnalyzer())
print blob.sentiment