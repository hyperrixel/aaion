# aaion

A project made for [NASA International Space Apps Challenge 2020](https://2020.spaceappschallenge.org/challenges/sustain/sleep-shift-scheduling-tool/teams/aaion/
).

## What is aaion?

Aaion is a human circadian management system to increase the user’s performance and ensure better daily comfort. It covers different levels of application: user and server levels. Shift is not only a classic work shift system. Server level’s administrators are able to create different day periods based on templates and monitorize the states of connected users’. Day periods can be different than 24 hours, so it fits for the needs of a long time space travel. System is based on the human circadian cycle. Our solution tries to fit the daily activities or time zone changes to the users circadian rhythm as best as possible.

![aaion - meaning of life](https://github.com/hyperrixel/aaion/blob/main/assets/01_meaning.png "aaion - meaning of life")

## Which problems can be solved?

![aaion - problems](https://github.com/hyperrixel/aaion/blob/main/assets/02_problem.png "problems")
![aaion - use-cases](https://github.com/hyperrixel/aaion/blob/main/assets/03_use-cases.png "use-cases")


## How it works?

The core of the concept was to create a software solution that is flexible and can run on different devices in very various environments. The existing solutions on the market cover only the main problems of common people, but they miss to provide widen and flexible solutions for rare problems. The whole software is deeply customizable. Each programming object works with default values that can be changed by user or administrator from server level.

The importance of our project is its flexibility. However our proof of concept covers one of the most common issues only the concept of the code is much much deeper.

The structure of our concept is independent from any programming language to provide a really flexible solution. We made an abstracted scheme that can be represented in any programming language. Aaion contains 6 different categories:
- Day
- Circadian rhythm
- Need
- Factor
- Activity
- Loss

### Day

However the base unit of time in SI metric system is second, people organize their own schedule by day and by hours. Day means the period of time during which the Earth makes a complete rotation around its axis. Besides this definition, people handle day as a time that equals with 24 hours. The approximation is good for the most of use-cases. We handle two different day types:
- “normal” day
- custom day
Day or normal day means the Earth-day that is 24 hours long and begins 00:00 (12 a.m.) and lasts 24:00 (12 p.m.). Custom day represents a day that can be shorter or longer than 24 hours. It occurs for example when we talk about other planets or environments under the surface or in space.

### Need

Need means the lack of something requisite in a specified time period. Need is the smallest unit that can be satisfied during one activity. A need has default values, but it can be changed. Need can handle functions to manage for example the depletion-level. The basic needs are:
- sleep
- work
- exercise
- any type of nutrition
- light
- noise
- temperature
- medication
It is important, that activity which can satisfy a special need is handled in the details of activity not in the details of need.

### Factor
Factor is the actual level of any kind of need. There are 2 different types of factor based on the possibility of intervention to modify their actual or future level:
- personal factor
- environmental factor
Personal factors can be changed or modified by the user such as sleep, caffeine, nutrition. It is adjustable or measurable. Environmental factors can be set by the environment, we can only measure or calculate its actual level.

### Activity

Activity means any kind of action that is able to satisfy a need for example eating, sleeping, taking medication.

### Loss

Loss means the mathematical difference between the optimal, circadian-based schedule and the actual schedule.

![aaion - loss](https://github.com/hyperrixel/aaion/blob/main/assets/04_loss.png "loss")

### Attributions of user

Attributions are special settings for users that are able to help for customizing the software to get the better user experience. An attribute can be rule based or custom. Rule based attribute means that setting a new value from a list results in a chain of automatic changes. For example, when a person changes the type of bedtime from late person to morning person, the system will recalculate the sleeping parameters such as the beginning and end of sleep cycle. We plan to manage the following attributions at the moment:


## Proof of Concept

Proof of Concept is available [here](fishque.com/aaion/).

![aaion - proof of concept screenshot](https://github.com/hyperrixel/aaion/blob/main/assets/aaion_poc_screen.png "aaion - proof of concept screenshot")
![aaion - Proof of Concept](https://github.com/hyperrixel/aaion/blob/main/assets/05_poc.png "aaion - Proof of Concept")
