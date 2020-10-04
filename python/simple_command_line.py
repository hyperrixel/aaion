from datetime import datetime, timedelta
from time import sleep
from typing import Optional



def createshiftplan(hours_to_shift: int, days_to_shift: int,
                    align_to_end: Optional[bool] = True) -> list:
    result = []
    if hours_to_shift < days_to_shift:
        pass
    else:
        daily_average_floor = int(hours_to_shift / days_to_shift)
        rest_hours = hours_to_shift % days_to_shift:
        if rest_hours == 0:
            for i in range(days_to_shift):
                result.append(daily_average_floor)
        else:
            if align_to_end:
                for i in range(days_to_shift):
                    if i >= days_to_shift - rest_hours:
                        result.append(daily_average_floor + 1)
                    else:
                        result.append(daily_average_floor)
            else:
                for i in range(days_to_shift):
                    if i < rest_hours:
                        result.append(daily_average_floor + 1)
                    else:
                        result.append(daily_average_floor)
    return result



def changeday(date: int, daycount: int) -> int:
    return datetime.timestamp(datetime.fromtimestamp(date)
                              + timedelta(days=daycount))



def getmidnight(date: int) -> int:
    return datetime.timestamp(datetime.combine(datetime.fromtimestamp(date),
                                               datetime.min.time()))



def inttotimeunits(date: int) -> dict:
    timeunits = {}
    timeunits['days'] = int(date // 86400)
    date -= timeunits['days'] * 86400
    timeunits['hours'] = int(date // 3600)
    date -= timeunits['hours'] * 3600
    timeunits['minutes'] = int(date // 60)
    date -= timeunits['minutes'] * 60
    timeunits['seconds'] = int(date)
    return timeunits



now = int(datetime.timestamp(datetime.today()))
today = getmidnight(now)

#############
# TIMEZONES #
#############

time_success = False
while not time_success:
    print('Input current timezone GMT +/- hours:')
    time_success = True
    answer = input('[?] ')
    try:
        personal_from = int(answer)
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to GMT difference.')
    if personal_from > 12 or personal_from < -12:
        time_success = False
        print('[!] GMT difference must be between +/- 12.')
time_success = False
while not time_success:
    print('Input target timezone GMT +/- hours:')
    time_success = True
    answer = input('[?] ')
    try:
        personal_to = int(answer)
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to GMT difference.')
    if personal_from > 12 or personal_from < -12:
        time_success = False
        print('[!] GMT difference must be between +/- 12.')
shift_hours_to_shift = personal_to - personal_from
if shift_hours_to_shift > 12 or shift_hours_to_shift < -12:
    print('[!] Your shift is {} hours.'.format(shift_hours_to_shift))
    if shift_hours_to_shift > 12:
        temp_shift = -24 + shift_hours_to_shift
    else:
        temp_shift = 24 + shift_hours_to_shift
    answer = ''
    while answer not in ['Y', 'N']:
        print('Would you prefer to shift {} hours instead? [Y]/[N]'.format(temp_shift))
        answer = input('[?] ')
        answer = answer.upper()
        if answer == 'Y':
            shift_hours_to_shift = temp_shift
print('[.] Your shift is {} hours.'.format(shift_hours_to_shift))

##########
# TRAVEL #
##########

time_success = False
while not time_success:
    print('Please enter date of departure of your travel in your time zone in format MM/DD/YYYY HH:MM')
    answer = input('[?] ')
    time_success = True
    try:
        travel_departure_time = int(datetime.timestamp(datetime.strptime(answer, r'%m/%d/%Y %H:%M')))
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to time.')
    if travel_departure_time <= now:
        time_success = False
        print('[!] Departure should be in the future.')
time_success = False
while not time_success:
    print('Please enter date of arrival of your travel in your time zone in format MM/DD/YYYY HH:MM')
    answer = input('[?] ')
    time_success = True
    try:
        travel_arrival_time = int(datetime.timestamp(datetime.strptime(answer, r'%m/%d/%Y %H:%M')))
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to time.')
    if travel_arrival_time <= travel_departure_time:
        time_success = False
        print('[!] Arrival should be at least a second later than departure.')

###############
# SLEEP HOURS #
###############

time_success = False
while not time_success:
    print('Input the hour of day when you usually go to sleep [0-23]:')
    time_success = True
    answer = input('[?] ')
    try:
        sleep_from = int(answer)
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to hours.')
    if sleep_from > 23 or sleep_from < 0:
        time_success = False
        print('[!] Hours must be between 0 and 23.')
time_success = False
while not time_success:
    print('Input the hour of day when you usually wake up [0-23]:')
    time_success = True
    answer = input('[?] ')
    try:
        sleep_to = int(answer)
    except Exception:
        time_success = False
        print('[!] Failed to convert your input to GMT difference.')
    if sleep_to > 23 or sleep_to < 0:
        time_success = False
        print('[!] Hours must be between 0 and 23.')
sleep_duration = sleep_to - sleep_from
if sleep_duration < 0:
    sleep_duration += 24
print('[.] You used to sleep {} hour(s) daily.'.format(sleep_duration))

################
# SHIFT PERIOD #
################

answer = ''
shift_before = False
while answer not in ['Y', 'N']:
    print('Would you like to shift your sleep before the travel? [Y]/[N]')
    answer = input('[?] ')
    answer = answer.upper()
    if answer == 'Y':
        shift_before = True
if shift_before:
    time_success = False
    while not time_success:
        print('Please enter date of the beginning of your shift period MM/DD/YYYY')
        answer = input('[?] ')
        time_success = True
        try:
            shift_begin_time = int(datetime.timestamp(datetime.strptime(answer, r'%m/%d/%Y')))
        except Exception:
            time_success = False
            print('[!] Failed to convert your input to time.')
        if shift_begin_time < today or shift_begin_time >= getmidnight(travel_departure_time):
            time_success = False
            print('[!] Shift should begin not earlier than today.')
    shift_end_time = getmidnight(travel_departure_time)
else:
    time_success = False
    while not time_success:
        print('Please enter date of the end of your shift period MM/DD/YYYY')
        answer = input('[?] ')
        time_success = True
        try:
            shift_end_time = int(datetime.timestamp(datetime.strptime(answer, r'%m/%d/%Y')))
        except Exception:
            time_success = False
            print('[!] Failed to convert your input to time.')
        if shift_end_time <= travel_arrival_time:
            time_success = False
            print('[!] Shift should begin not earlier than the end of your travel.')
    shift_begin_time = getmidnight(travel_arrival_time)
shift_duration = shift_end_time - shift_begin_time
shift_dict = inttotimeunits(shift_duration)
print('[.] Your shift period is {} seconds long, it means:'.format(shift_duration), end='')
for key, value in shift_dict.items():
    if value > 0:
        print(' {} {}'.format(value, key), end='')
print('.')
shift_plan = createshiftplan(shift_hours_to_shift, shift_dict['days'])
if shift_hours_to_shift > 0:
    print('[.] You have a FORWARD shift plan:')
else:
    print('[.] You have a BACKWARD shift plan:')
for i, row in enumerate(shift_plan, 1):
    print('--- Day {}, {} hours.'.format(i, row))

# Megkérdezni, akar-e kihagyni alvást.
