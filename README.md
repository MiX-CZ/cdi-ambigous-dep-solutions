CDI ambigous dependency solutions
=========

### Imagine the following situation:
You have interface Config and its implementation Original.class. Also you have requirement from your boss that change in Original.class is prohibited (imagine some common config module) and you must avoid to somehow mess up the already working injection of Config interface.  But thing is that we really need to change it. So how we can do this in CDI way and don't blow up already working code?

* Create MyVersion.class that implement your own implementation of the Config interface. But now we need to handle ambigous dependency problem, why? If we try to inject Config -> inject provider find two classes that implements Config interface and throw exception. Thing is that classes are annotated @Default. This tell inject provider, which class must be injected as default behaviour. So as you can see, we have exactly two of those, so exception is right thing to do.

* So how we can avoid this annoing exception? We have few posibilities. Also I need to warn you. If you found article (CDI Dependency Injection) on DZone.. It contains error and doesn't work (because of ambigous dependency). At the end of this short article you should know where is error hidden :-)

* First solution is, as article from DZone propose, annotate MyVersion class with @Alternative. Now our exception is not thrown because injection provider check both classes and find out that one is annotated with @Default and second is annotated with @Alernative. You can guess what is injected :-) Did you guess Original.class? Than you have right! But what if I need MyVersion.class to be injected? Then you need to explicitly do it in beans.xml. Which disable Original.class injection and inject @Alternative class instead. It looks that it may works, but remember that you are not allowed to mess with already working injections. So what else?

* Second solution is to forgot on @Alternative and create new qualifier such as @ConfigFactory (or @Smurf, its really not important and name is up to you). Now you can inject exaclty what you need. If you want to inject second one, you just type @Inject @ConfigFactory Config and MyVersion.class is injected. If I need Orignal.class I use simple @Inject Config. Its working because of that @Default annotation -> remember? So question is. It is something better? And answer is, it depends :-) If you need moore flexibility and need to deside on runtime which implementation of Config you need, look at the third example.

* Third and not necessary best solution is use CDI Producer. And here comes the little thing why example in article on DZone is wrong. Producer function behave as @Inject with @Default annotation. So, if I create something like this: @Produces Config desideWhatInject(){...}, I'm in the same situation as at the beginning. Injection provider find two default classes that is implementation of Config interface and throw ambigous dependency excetion.. So what to do now? Combine both previous solutions. MyVersion.class annotate with @Alternative. Now I know that @Default would be used every time. Annotate @Produces method with qualifier @ConfigFactory and inside this method decide what you need to inject (at runtime).

So how it looks and works together? Simple @Inject Config depends on @Default annotation and Original.class is injected. So old code is still intact and depends on original inject as our boss told us. And if we need second one, do this: @Inject @ConfigFactory Config. This time your producer method deside what is injected. So your new code depends on Original.class or MyVersion.class and is really up to you how create this decision rule. With some CDI magic, you are able to even change this decision rule at the runtime simple by change some properties file. No recompile even restart is not needed :-)
 
### Build
Project is build with maven. It contains code example and Arquillian test with remote JBoss As 7.2 container and embedded Glassfish 3.1.1

Source code is distributed under MIT license

