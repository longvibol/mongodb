db.students.aggregate([
    {
        $unwind: "$hobbies"
    },
    {
        $group:{_id:{age:"$age"},allHobbies:{$addToSet:"$hobbies"}}
    }
])

//----------------------------------- using $unwind -------------------------------------

db.students.aggregate([
    {
        $unwind: "$hobbies"
    },
    {
        $group:{_id:{age:"$age"},allHobbies:{$push:"$hobbies"}}
    }
])


//----------------------------------- using $addToSet -------------------------------------

db.students.aggregate([
    {
        $unwind: "$hobbies"
    }
])


