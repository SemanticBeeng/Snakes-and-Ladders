import pandas as pd
from datetime import datetime
from rpy2.robjects import r, pandas2ri

#from com.knowscieng.jepp.sclaython import *

pandas2ri.activate()

r_df = r['iris'].head()

p_df = pd.DataFrame(r_df)

print("Panda df from R df")
print(p_df)

ts = pd.Timestamp(datetime(2012, 5, 1))

# # TsUtils.ts = jep.Jep.getValue(ts)
# #
# # TsUtils.df = p_df
#
# ageGroup = ScalaUtils.ageGroupMethod(21.0)
# print(ageGroup + 1)
#
# ages = ScalaUtils.ages()
# print(ages.head().toString())
#
# people = ScalaUtils.people()
# print(people)

