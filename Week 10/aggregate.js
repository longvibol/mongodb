db.contacts.aggregate([
    {
        $match: {gender:"female"}
    },
    {
        $group: {_id:{state:"$location.state"}, count:{$sum:1}}
    }
])


db.contacts.aggregate([
     {
        $group: {_id:{state:"$location.state"}, count:{$sum:1}}
    }
])

db.contacts.aggregate([
    {
        $match: {gender:"female"}
    },
    {
        $group: {_id:{state:"$location.state"}, count:{$sum:1}}
    },
    {
        $sort: {count:-1}
    },
    {
        $limit: 5
    }
])

db.contacts.aggregate([
    {
        $project: {
            _id:0,gender: 1,fullname:{$concat:["$name.frist"," ","$name.last"]}
        }
    }
])


db.contacts.aggregate([
    {
        $project: {
            _id:0,gender: 1,fullname:{$concat:[{$toUpper:"$name.frist"}," ",{$toUpper:"$name.last"}]}
        }
    }
])


db.contacts.aggregate([
    {
        $project: {
            _id:0,gender: 1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]}
        }
    }
])

//====================================== First Step ====================================

db.contacts.aggregate([
    {
        $project: {_id:0,gender: 1,name:1,email:1,
            location:{type:"Point",coordinates:[
                "$location.coordinates.longitude",
                "$location.coordinates.latitude"
            ]
        }

        }

    },
    {
        $project: {
            _id:0,gender: 1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]},location:1,
        },
        
    },
    
    {$limit: 5},
])

//====================================== convert from String to Number ====================================

db.contacts.aggregate([
    {
        $project: {_id:0,gender: 1,name:1,email:1,
            location:{type:"Point",coordinates:[
                {$convert: {input:"$location.coordinates.longitude", to:"double"}},
                {$convert: {input:"$location.coordinates.latitude", to:"double"}}
            ]
        }

        }

    },
    {
        $project: {
            _id:0,gender: 1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]},location:1,
        },
        
    },
])


//====================================== convert from Brithday to ISO Date Option 1 ====================================

db.contacts.aggregate([
    {
        $project: {_id:0,gender: 1,name:1,email:1,
            birthdate:{$convert: {input:"$dob.date", to:"date"}},
            location:{type:"Point",coordinates:[
                {$convert: {input:"$location.coordinates.longitude", to:"double"}},
                {$convert: {input:"$location.coordinates.latitude", to:"double"}}
            ]
        }

        }

    },
    {
        $project: {
            _id:0,gender: 1,
            birthdate:1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]},location:1,
        },
        
    },
    {
        $limit: 5,
    }
])

//====================================== convert from Brithday to ISO Date Option 2-Use Method ====================================

db.contacts.aggregate([
    {
        $project: {_id:0,gender: 1,name:1,email:1,
            birthdate:{$toDate:"$dob.date"},
            location:{type:"Point",coordinates:[
                {$convert: {input:"$location.coordinates.longitude", to:"double"}},
                {$convert: {input:"$location.coordinates.latitude", to:"double"}}
            ]
        }

        }

    },
    {
        $project: {
            _id:0,gender: 1,
            birthdate:1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]},location:1,
        },
        
    },
    {
        $limit: 5,
    },
   
])

//====================================== convert from Brithday to ISO Date Option 2-Use Method ====================================
db.contacts.aggregate([
    {
        $project: {_id:0,gender: 1,name:1,email:1,
            birthdate:{$toDate:"$dob.date"},
            location:{type:"Point",coordinates:[
                {$convert: {input:"$location.coordinates.longitude", to:"double"}},
                {$convert: {input:"$location.coordinates.latitude", to:"double"}}
            ]
        }

        }

    },
    {
        $project: {
            _id:0,gender: 1,
            birthdate:1,
            fullname:{$concat:[
                {$toUpper:{$substrCP:["$name.first",0,1]}},
                {$substrCP:["$name.first",1,{$subtract:[{$strLenCP:"$name.first"},1]}]},
                " ",
                {$toUpper:{$substrCP:["$name.last",0,1]}},
                {$substrCP:["$name.last",1,{$subtract:[{$strLenCP:"$name.last"},1]}]},
                ]},location:1,
        },
    },
    {
        $group:{_id:{year:{$year:"$birthdate"}},numPerson:{$sum:1}}
    },
    {
        $sort:{numPerson:-1}
    }

])



















